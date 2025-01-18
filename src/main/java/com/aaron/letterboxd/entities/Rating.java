package com.aaron.letterboxd.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " ")
    private Double rating;

    @Column(name = " ")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Rating() {
    }

    public Rating(Double rating, LocalDate date, Movie movie) {
        this.rating = rating;
        this.date = date;
        this.movie = movie;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", date=" + date +
                ", movie=" + movie +
                '}';
    }
}
