package com.aaron.letterboxd.services;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.aaron.letterboxd.dto.MovieCsvRecord;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TmdbService {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String API_READ_ACCESS_TOKEN = System.getenv("API_READ_ACCESS_TOKEN");
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private final OkHttpClient client = new OkHttpClient();
    private static final Logger logger = Logger.getLogger(TmdbService.class.getName());

    // General method to make an HTTP request
    private Response makeRequest(String endpoint) throws IOException, InterruptedException {
        String url = BASE_URL + endpoint;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + API_READ_ACCESS_TOKEN)
                .build();

        Response response = client.newCall(request).execute();

        // Handle rate-limiting
        if (response.code() == 429) {
            logger.warning("Rate limit hit. Retrying after delay...");
            TimeUnit.SECONDS.sleep(1);
            response = client.newCall(request).execute();
        }

        return response;
    }

    // Fetch details for a single movie
    public void fetchMovieDetails(MovieCsvRecord movieCsvRecord) throws IOException, InterruptedException {
        String query = movieCsvRecord.getName() + " " + movieCsvRecord.getYear();
        String endpoint = "/search/movie?api_key=" + API_KEY + "&query=" + query;
        Response response = makeRequest(endpoint);

        if (response.isSuccessful()) {
            String jsonResponse = response.body().string();
            logger.info("JSON response for " + query + ": " + jsonResponse);
        } else {
            logger.warning("Failed to fetch details for " + query + ". Status code: " + response.code());
        }
    }
    // TODO * query movie details by movie_id

    // Fetch details for multiple movies
    public void bulkFetchMovieDetails(List<MovieCsvRecord> movieTitles) throws IOException, InterruptedException {
        for (MovieCsvRecord movie : movieTitles) {
            fetchMovieDetails(movie);
        }
    }
}