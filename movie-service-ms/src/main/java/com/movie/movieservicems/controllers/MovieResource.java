package com.movie.movieservicems.controllers;

import com.movie.movieservicems.models.*;
import com.movie.movieservicems.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin("*")
public class MovieResource {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    MovieService ms;


    @ResponseBody
    @GetMapping(value = "/movie")
    public MovieList getAllMovies(){
        return ms.getAllMovies();
    }

    @ResponseBody
    @GetMapping(value = "/movie/{id}")
    public Movie getMovieById(@PathVariable("id") int id){
        return ms.getMovieById(id);
    }

    @ResponseBody
    @GetMapping(value = "/movie/name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name){
        return ms.getMovieByName(name);
    }

    @ResponseBody
    @PostMapping(value = "/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return ms.createMovie(movie);
    }

    @DeleteMapping(value = "/movie/{id}")
    public void deleteMovie(@PathVariable int id){
        ms.deleteMovie(id);
    }

    // Cross Microservice: Interacting with Multiplex Service for Multiplex CRUD (3 Methods)
    @ResponseBody
    @GetMapping("/multiplex")
    public MultiplexList getMultiplexes(){
        return restTemplate.getForObject(
                "http://multiplex-service/multiplex", MultiplexList.class);
    }

    @ResponseBody
    @GetMapping("/multiplex/{id}")
    public Multiplex getMultiplexById(@PathVariable int id){
        return restTemplate.getForObject(
                "http://multiplex-service/multiplex/" + id, Multiplex.class);
    }

    @ResponseBody
    @PostMapping("/multiplex")
    public Multiplex createMultiplex(@RequestBody Multiplex multiplex){
        return restTemplate.postForObject(
                "http://multiplex-service/multiplex/", multiplex, Multiplex.class);
    }



    //Cross Microservice: Interaction with Multiplex Service for Allocating Movies to Multiplexes (4 Methods)
    @ResponseBody
    @PostMapping("/multiplex/movies")
    public MultiplexMovie addMovie(@RequestBody MultiplexMovie movie){
        return restTemplate.postForObject(
                "http://multiplex-service/multiplex/movies", movie, MultiplexMovie.class);
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/movies")
    public MultiplexMovieList getAllMoviesInMultiplexInAllMultiplexes() {
        return restTemplate.getForObject("http://multiplex-service/multiplex/movies", MultiplexMovieList.class);
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/{id}/movies")
    public MultiplexMovieList getAllMoviesInMultiplexById(@PathVariable int id) {
        return restTemplate.getForObject("http://multiplex-service/multiplex/" + id + "/movies", MultiplexMovieList.class);
    }

    @DeleteMapping(value = "/multiplex/movies/{id}")
    public void deleteMovieFromMultiplex(@PathVariable int id){
         restTemplate.delete("http://multiplex-service/multiplex/movies/" + id);
    }

}

