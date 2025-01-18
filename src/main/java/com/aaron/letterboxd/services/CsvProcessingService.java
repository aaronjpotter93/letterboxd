package com.aaron.letterboxd.services;

import com.aaron.letterboxd.entities.Movie;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvProcessingService {

    private final EntityMappingService entityMappingService;

    public CsvProcessingService(EntityMappingService entityMappingService) {
        this.entityMappingService = entityMappingService;
    }

    public List<Movie> processMoviesCsv(Path csvFilePath) throws IOException {
        List<Movie> movies = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(csvFilePath)) {
            CSVReader csvReader = new CSVReader(reader);
            String[] row;

            while ((row = csvReader.readNext()) != null) {
                if (!isHeaderRow(row)) {  // Skip header if necessary
                    Movie movie = entityMappingService.mapToMovie(row);
                    movies.add(movie);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    private boolean isHeaderRow(String[] row) {
        return row[0].equalsIgnoreCase("name");
    }
}
