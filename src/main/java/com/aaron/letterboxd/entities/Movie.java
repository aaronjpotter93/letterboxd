package com.aaron.letterboxd.entities;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = " ", unique = true)
    private String name;

    @Column(name = " ")
    private Year year;

    @Column(name = " ")
    private String uri;

    public Movie() {
    }

    public Movie(String name, Year year, String uri) {
        this.name = name;
        this.year = year;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", letterboxdUrl='" + uri + '\'' +
                '}';
    }

    //     More attributes to add but can't get from letterboxd
//    -----------------------------------------------------
//    - cast
//    - crew
//    - ratings

}
