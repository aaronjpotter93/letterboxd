package com.aaron.letterboxd.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieApiService {
    OkHttpClient client = new OkHttpClient();

    // TODO * add api keys to authenticate request
    Request request = new Request.Builder()
            .url("https://api.themoviedb.org/3/authentication")
            .get()
            .addHeader("accept", "application/json")
            .build();

    Response response = client.newCall(request).execute();

    public MovieApiService() throws IOException {
    }
}
