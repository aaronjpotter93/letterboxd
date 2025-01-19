package com.aaron.letterboxd.controllers;

import com.aaron.letterboxd.dto.MovieCsvRecord;
import com.aaron.letterboxd.services.CsvProcessingService;
import com.aaron.letterboxd.services.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final CsvProcessingService csvProcessingService;
    private final TmdbService tmdbService;

    @Autowired
    public MovieController(CsvProcessingService csvProcessingService, TmdbService tmdbService) {
        this.csvProcessingService = csvProcessingService;
        this.tmdbService = tmdbService;
    }

    @GetMapping("/fetch-first")
    public ResponseEntity<String> fetchFirstMovieDetails() {
        try {
            List<MovieCsvRecord> movieCsvRecords = csvProcessingService.findMovieTitles();

            if (movieCsvRecords.isEmpty()) {
                return ResponseEntity.ok("No movie records found.");
            }

            tmdbService.fetchMovieDetails(movieCsvRecords.get(0));
            return ResponseEntity.ok("Successfully fetched details for: " + movieCsvRecords.get(0).getName());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}