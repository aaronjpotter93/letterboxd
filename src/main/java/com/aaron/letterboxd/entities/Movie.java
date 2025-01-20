package com.aaron.letterboxd.entities;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TMDB Attributes
    @Column(name = "adult")
    private Boolean adult;
    @Column(name = "backdrop_path")
    private String backdropPath;
    @Column(name = "overview")
    private String overview;
    @Column(name = "poster_path")
    private String posterPath;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "runtime")
    private Integer runtime; // depends on detail request by movie_id
    @Column(name = "status")
    private String status; // depends on detail request by movie_id
    @Column(name = "title")
    private String title;

    // Letterboxd Attributes
    @Column(name = "uri")
    private String uri;

    // TODO * Map to watchlist table
    @Column(name = "watched")
    private Boolean watched; // set through the csv controller when reading through the watched list?
    // TODO * Map to likes table
    @Column(name = "liked")
    private Boolean liked;
    // TODO * Map to ratings table
    @Column(name = "rating")
    private Double rating;

    public Movie() {
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime=" + runtime +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                ", watched=" + watched +
                ", liked=" + liked +
                ", rating=" + rating +
                '}';
    }
}
