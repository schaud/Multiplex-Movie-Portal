package com.movie.multiplexservicems.repositories;

import com.movie.multiplexservicems.models.MultiplexMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MultiplexMovieRepository extends JpaRepository<MultiplexMovie, Integer> {

    MultiplexMovie findById(int id);
    List<MultiplexMovie> findAll();

}
