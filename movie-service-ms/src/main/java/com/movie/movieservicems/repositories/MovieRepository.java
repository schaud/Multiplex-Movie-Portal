package com.movie.movieservicems.repositories;

import com.movie.movieservicems.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findById(int id);
    List<Movie> findAll();
    Movie findByName(String name);

}
