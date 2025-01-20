package com.aaron.letterboxd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// From JSON -> sanitized to -> enriched to -> CSV (or whatever resource I want it in for access on Retool)
public class RetoolMovieJsonRecord {

    // TMDB Gathered Attributes
    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("title")
    private String title;

    // Letterboxd Gathered Attributes
    @JsonProperty("letterboxd_uri")
    private String letterboxdUri;
    @JsonProperty("watched")
    private Boolean watched; // depends on watched
    @JsonProperty("liked")
    private Boolean liked; // depends on likes/films
    @JsonProperty("rating")
    private Double rating; // depends on ratings
}
