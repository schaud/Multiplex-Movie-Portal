package com.movie.multiplexservicems.controllers;


import com.movie.multiplexservicems.models.Movie;
import com.movie.multiplexservicems.models.MovieList;
import com.movie.multiplexservicems.models.Multiplex;
import com.movie.multiplexservicems.models.MultiplexList;
import com.movie.multiplexservicems.services.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin("*")
public class MultiplexResource {

    @Autowired
    MultiplexService ms;

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


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


    // Cross Microservice: Interacting with Movie Service
    @GetMapping("/movie")
    public MovieList getMovies(){
        return restTemplate.getForObject(
                "http://movie-service/movie", MovieList.class);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable int id){
        return restTemplate.getForObject(
                "http://movie-service/movie/" + id, Movie.class);
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return restTemplate.postForObject(
                "http://movie-service/movie/", movie, Movie.class);
    }


}
