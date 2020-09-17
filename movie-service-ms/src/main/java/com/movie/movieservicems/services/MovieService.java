package com.movie.movieservicems.services;

import com.movie.movieservicems.models.Movie;
import com.movie.movieservicems.models.MovieList;
import com.movie.movieservicems.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MovieService implements MovieServiceI {

    @Autowired
    MovieRepository mr;

    @Override
    public MovieList getAllMovies() {
        MovieList movieList = new MovieList();
        List<Movie> movieListBase = mr.findAll();
        movieList.setMovies(movieListBase);
        return movieList;
    }

    @Override
    public Movie getMovieById(int id) {
        return mr.findById(id);
    }

    @Override
    public Movie getMovieByName(String name) {
        return mr.findByName(name);
    }

    @Override
    public Movie createMovie(Movie movie) {
        return mr.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        mr.delete(mr.findById(id));
    }
}
