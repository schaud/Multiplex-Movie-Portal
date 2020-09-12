package com.movie.multiplexservicems.repositories;

import com.movie.multiplexservicems.models.Multiplex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiplexRepository extends JpaRepository<Multiplex, Integer> {

    Multiplex findById(int id);
    List<Multiplex> findAll();
}
