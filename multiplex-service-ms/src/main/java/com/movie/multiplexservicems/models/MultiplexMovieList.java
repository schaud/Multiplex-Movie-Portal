package com.movie.multiplexservicems.models;

import java.util.List;

public class MultiplexMovieList {

    List<MultiplexMovie> movies;

    public MultiplexMovieList(List<MultiplexMovie> movies) {
        this.movies = movies;
    }

    public MultiplexMovieList() {
    }

    public List<MultiplexMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<MultiplexMovie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MultiplexMovieList{" +
                "movies=" + movies +
                '}';
    }
}
