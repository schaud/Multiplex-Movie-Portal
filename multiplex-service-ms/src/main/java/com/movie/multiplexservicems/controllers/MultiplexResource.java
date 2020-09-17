package com.movie.multiplexservicems.controllers;


import com.movie.multiplexservicems.models.*;
import com.movie.multiplexservicems.services.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;


@RestController
@CrossOrigin("*")
public class MultiplexResource {

    @Autowired
    MultiplexService ms;

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


    // CRUD Methods for Multiplex
    @ResponseBody
    @GetMapping(value = "/multiplex")
    public MultiplexList getAllMovies(){
        return ms.getAllMultiplexes();
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/{id}")
    public Multiplex getMultiplexById(@PathVariable("id") int id){
        return ms.getMultiplexById(id);
    }

    @ResponseBody
    @PostMapping(value = "/multiplex")
    public Multiplex createMultiplex(@RequestBody Multiplex multiplex){
        return ms.createMultiplex(multiplex);
    }

    @DeleteMapping(value = "/multiplex/{id}")
    public void deleteMultiplex(@PathVariable int id) {
       ms.deleteMultiplex(id);
    }

    @ResponseBody
    @PutMapping(value = "/multiplex")
    public Multiplex updateMultiplex(@RequestBody Multiplex multiplex){
        return ms.updateMultiplex(multiplex);
    }

    // Movies in the Multiplex and Allocation
    @ResponseBody
    @PostMapping(value = "/multiplex/movies")
    public MultiplexMovie addMovie(@RequestBody MultiplexMovie movie){
        return ms.addMovieToMultiplex(movie);
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/movies")
    public MultiplexMovieList getAllMoviesInMultiplexInAllMultiplexes() {
        return ms.getAllMoviesInAllMultiplexes();
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/{id}/movies")
    public MultiplexMovieList getAllMoviesInMultiplexById(@PathVariable int id) {
        return ms.getAllMoviesInMultiplexById(id);
    }

    @DeleteMapping(value = "/multiplex/movies/{id}")
    public void deleteMovieFromMultiplex(@PathVariable int id){
        ms.deleteMovieFromMultiplex(id);
    }


    // Cross Microservice: Interacting with Movie Service (4 Methods)
    @ResponseBody
    @GetMapping("/movie")
    public MovieList getMovies(){
        return restTemplate.getForObject(
                "http://movie-service/movie", MovieList.class);
    }

    @ResponseBody
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable int id){
        return restTemplate.getForObject(
                "http://movie-service/movie/" + id, Movie.class);
    }

    @ResponseBody
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return restTemplate.postForObject(
                "http://movie-service/movie/", movie, Movie.class);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable int id){
        restTemplate.delete("http://movie-service/movie/" + id);
    }




}
