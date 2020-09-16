package com.movie.movieservicems.controllers;

import com.movie.movieservicems.models.Movie;
import com.movie.movieservicems.models.MovieList;
import com.movie.movieservicems.models.Multiplex;
import com.movie.movieservicems.models.MultiplexList;
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

    // Interacting with Multiplex Service at Port 8082
    @GetMapping("/multiplex")
    public MultiplexList getMultiplexes(){
        return restTemplate.getForObject(
                "http://multiplex-service/multiplex", MultiplexList.class);
    }

    @GetMapping("/multiplex/{id}")
    public Multiplex getMultiplexById(@PathVariable int id){
        return restTemplate.getForObject(
                "http://multiplex-service/multiplex/" + id, Multiplex.class);
    }

    @PostMapping("/multiplex")
    public Multiplex createMultiplex(@RequestBody Multiplex multiplex){
        return restTemplate.postForObject(
                "http://multiplex-service/multiplex/", multiplex, Multiplex.class);
    }

}
