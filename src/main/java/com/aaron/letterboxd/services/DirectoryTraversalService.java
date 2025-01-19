package com.aaron.letterboxd.services;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class DirectoryTraversalService {
    private static final String BASE_PATH = "src/main/resources/letterboxd-data";
    /**
     * Returns a list of paths for the CSV files to process.
     */
    public List<Path> getCsvFilePaths() {
        return Arrays.asList(
                Paths.get(BASE_PATH, "watched.csv"),
                Paths.get(BASE_PATH, "watchlist.csv")
        );
    }
}
