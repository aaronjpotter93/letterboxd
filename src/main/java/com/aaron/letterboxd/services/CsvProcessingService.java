package com.aaron.letterboxd.services;

import com.aaron.letterboxd.dto.MovieCsvRecord;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvProcessingService {

    private final DirectoryTraversalService directoryTraversalService;

    public CsvProcessingService(DirectoryTraversalService directoryTraversalService) {
        this.directoryTraversalService = directoryTraversalService;
    }

    public List<MovieCsvRecord> findMovieTitles() {
        List<MovieCsvRecord> movieCsvRecords = new ArrayList<>();

        List<Path> filePaths = directoryTraversalService.getCsvFilePaths();
        for (Path path : filePaths) {
            try (Reader reader = new FileReader(path.toFile())) {
                CsvToBean<MovieCsvRecord> csvToBean = new CsvToBeanBuilder<MovieCsvRecord>(reader)
                        .withType(MovieCsvRecord.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<MovieCsvRecord> parsedRecords = csvToBean.parse();
                movieCsvRecords.addAll(parsedRecords);

                movieCsvRecords.addAll(csvToBean.parse());
                System.out.println("Successfully processed " + path.getFileName());
                parsedRecords.forEach(movie -> System.out.println("Movie found: " + movie + " Found in: " + path.getFileName()));
            } catch (Exception e) {
                System.out.println("Error processing file " + path.getFileName());
                e.printStackTrace();
            }
        }
        return movieCsvRecords;
    }
}
