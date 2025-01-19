package com.aaron.letterboxd.services;

import org.springframework.stereotype.Service;

// PURPOSE * to coordinate the csv reading service with the tmdb service to initialize database with movie entities
@Service
public class MovieInitializationService {
    // import csvReaderService
    // import directoryTraversalService
    // import tmdbService
    // import entityMappingService

    // csvReaderService & directoryTraversalService -> read csv directories and return a list of unique movie titles

    // movieRepository -> check db for existing movie titles, return a list of movies that are not present in db

    // tmdbService -> request tmdb for movie details using list of movie titles gathered that are new to db

    // entityMappingService -> using returned json from tmdb - persist movies
}
