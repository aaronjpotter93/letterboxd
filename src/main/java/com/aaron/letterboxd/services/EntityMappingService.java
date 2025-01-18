package com.aaron.letterboxd.services;

import com.aaron.letterboxd.entities.Movie;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class EntityMappingService {
    public Movie mapToMovie(String[] csvRow) {
        if (csvRow.length < 3) {
            throw new IllegalArgumentException("Invalid CSV row for Movie: " + String.join(", ", csvRow));
        }

        String name = csvRow[0];  // Assuming the first column is the name
        Year year = Year.parse(csvRow[1]);  // Assuming the second column is the year
        String uri = csvRow[2];  // Assuming the third column is the URI

        return new Movie(name, year, uri);
    }
    // Add similar methods for other entities
}
