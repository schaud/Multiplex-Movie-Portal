package com.movie.allocationservicems.repositories;

import com.movie.allocationservicems.models.MovieScreen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<MovieScreen, Integer> {


}
