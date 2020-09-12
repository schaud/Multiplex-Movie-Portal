package com.movie.multiplexservicems.models;

import lombok.Data;

import java.util.List;

@Data
public class MovieList {

    List<Movie> movies;

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
