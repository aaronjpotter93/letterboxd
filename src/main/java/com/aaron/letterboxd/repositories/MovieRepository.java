package com.aaron.letterboxd.repositories;

import com.aaron.letterboxd.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    /**
     * Checks if a movie with the given name exists in the database.
     *
     * @param name the name of the movie
     * @return true if a movie with the given name exists, false otherwise
     */
    boolean existsByName(String name);

    /**
     * Finds a movie by its name.
     *
     * @param name the name of the movie
     * @return an Optional containing the movie if found, or an empty Optional if not
     */
    Optional<Movie> findByName(String name);
}
