package com.aaron.letterboxd.dto;

import com.opencsv.bean.CsvBindByName;

public class RatingCsvRecord {

    @CsvBindByName(column = "Date")
    private String date;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Year")
    private String year;

    @CsvBindByName(column = "Letterboxd URI")
    private String letterboxdUri;

    @CsvBindByName(column = "Rating")
    private Double rating;

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLetterboxdUri() {
        return letterboxdUri;
    }

    public void setLetterboxdUri(String letterboxdUri) {
        this.letterboxdUri = letterboxdUri;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingCsvRecord{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", letterboxdUri='" + letterboxdUri + '\'' +
                ", rating=" + rating +
                '}';
    }
}
