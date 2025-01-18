package com.aaron.letterboxd.services;

import com.aaron.letterboxd.entities.Movie;
import com.aaron.letterboxd.repositories.MovieRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieInitializationService {

    private final MovieRepository movieRepository;
    private final MovieApiService movieApiService;

    public MovieInitializationService(MovieRepository movieRepository, MovieApiService movieApiService) {
        this.movieRepository = movieRepository;
        this.movieApiService = movieApiService;
    }

    public void initializeMoviesFromDirectory(Path directoryPath) throws IOException {
        Set<String> movieMentions = extractMovieMentions(directoryPath);

        for (String movie : movieMentions) {
            if (!movieRepository.existsByName(movie)) {
                Optional<Movie> movieDetails = movieApiService.fetchMovieDetails(movie);
                movieDetails.ifPresent(movieRepository::save);
            }
        }
    }

    private Set<String> extractMovieMentions(Path directoryPath) throws IOException {
        Set<String> movieMentions = new HashSet<>();
        Files.walk(directoryPath)
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".csv"))
                .forEach(path -> {
                    try (Reader reader = Files.newBufferedReader(path)) {
                        CSVReader csvReader = new CSVReader(reader);
                        String[] row;
                        while ((row = csvReader.readNext()) != null) {
                            // TODO
                            // Extract movie names/mentions from rows, e.g., by regex or known column indices
                            // Add to movieMentions set
                        }
                    } catch (IOException | CsvValidationException e) {
                        e.printStackTrace();
                    }
                });
        return movieMentions;
    }
}
