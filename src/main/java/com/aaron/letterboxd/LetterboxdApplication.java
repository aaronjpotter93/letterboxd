package com.aaron.letterboxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LetterboxdApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetterboxdApplication.class, args);
    }

//    TODO * Check movies table. If its empty:
//          - Run a csv parse on watchlist -> add to a MovieCsvRecord DTO Collection(call csvProcessingService.getWatchlist)
//              - List<MovieCsvRecord> + watchlist, uri
//          - Run a csv parse on watched -> add to a MovieCsvRecord DTO Collection & set watched flag to true(call csvProcessingService.getWatched)
//              - List<MovieCsvRecord> + watched, uri
//          - Run a csv parse on liked and for each movie found, set its MovieCsvRecord DTO like flag to true(call csvProcessingService.setLiked)
//              - List<MovieCsvRecord> + liked
//          - Run a csv parse on rating and for each movie found, set its MovieCsvRecord DTO rating to value found(call csvProcessingService.setRating)
//              - List<MovieCsvRecord> + rating
//          -
//          - Map List<MovieCsvRecord>'s to List<Movie>'s(make use of a stream to created Movie objects based on MovieCsvRecords)
//
//          TODO
//                List<Movie> movies = movieCsvRecords.stream()
//                        .map(csvRecord -> {
//                            Movie movie = new Movie();
//                            movie.setTitle(csvRecord.getName());
//                            movie.setUri(csvRecord.getUri());
//                            movie.setWatched(csvRecord.getWatched());
//                            movie.setLiked(csvRecord.getLiked());
//                            movie.setRating(csvRecord.getRating());
//                            return movie;
//                        })
//                        .collect(Collectors.toList());
//
//
//          TODO
//          - Run a TMDB api search for all movies using 'name' & 'year' parameters (call TmdbService)
//              - List<Movie> + adult, backdrop, overview, poster, release, title
//          - Run a TMDB api movie/details request for all movies by first movie_id index from search (call TmdbService)
//              - List<Movie> + runtime, status

}