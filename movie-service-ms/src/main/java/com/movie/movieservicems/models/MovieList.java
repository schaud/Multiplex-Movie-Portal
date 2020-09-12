package com.movie.movieservicems.models;

import lombok.Data;

import java.util.List;

@Data
public class MovieList {

    List<Movie> movies;

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
