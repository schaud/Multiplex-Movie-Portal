package com.movie.multiplexservicems.services;

import com.movie.multiplexservicems.models.Multiplex;
import com.movie.multiplexservicems.models.MultiplexList;
import com.movie.multiplexservicems.models.MultiplexMovie;
import com.movie.multiplexservicems.models.MultiplexMovieList;

import java.util.Optional;


public interface MultiplexServiceI {

     MultiplexList getAllMultiplexes();
     Multiplex getMultiplexById(int id);
     Multiplex createMultiplex(Multiplex multiplex);
     Multiplex updateMultiplex(Multiplex multiplex);
     void deleteMultiplex(int id);

     MultiplexMovieList getAllMoviesInAllMultiplexes();
     MultiplexMovieList getAllMoviesInMultiplexById(int id);
     MultiplexMovie getMultiplexMovieById(int id);
     MultiplexMovie addMovieToMultiplex(MultiplexMovie movie);
     void deleteMovieFromMultiplex(int id);

}
