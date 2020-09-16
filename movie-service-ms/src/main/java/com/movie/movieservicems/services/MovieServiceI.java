package com.movie.movieservicems.services;

import com.movie.movieservicems.models.Movie;
import com.movie.movieservicems.models.MovieList;

public interface MovieServiceI {

    MovieList getAllMovies();
    Movie getMovieById(int id);
    Movie getMovieByName(String name);
    Movie createMovie(Movie movie);

}
