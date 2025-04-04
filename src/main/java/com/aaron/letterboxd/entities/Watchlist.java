package com.aaron.letterboxd.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " ")
    private LocalDate date;

    @OneToOne
    @JoinColumn
    private Movie movie;

    public Watchlist() {
    }

    public Watchlist(LocalDate date, Movie movie) {
        this.date = date;
        this.movie = movie;
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
        return "Watchlist{" +
                "id=" + id +
                ", date=" + date +
                ", movie=" + movie +
                '}';
    }

    // Just watch api to add StreamingServices attribute
}
