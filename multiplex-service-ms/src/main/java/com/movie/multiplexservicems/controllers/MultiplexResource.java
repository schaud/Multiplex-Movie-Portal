package com.movie.multiplexservicems.controllers;


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

    // Interacting with Movie Service at Port 8081
    @GetMapping("/movie")
    public MovieList getMovies(){
        return restTemplate.getForObject(
                "http://movie-service/movie", MovieList.class);
    }

    @ResponseBody
    @GetMapping(value = "/multiplex")
    public MultiplexList getAllMovies(){
        return ms.getAllMultiplexes();
    }

    @ResponseBody
    @GetMapping(value = "/multiplex/{id}")
    public Multiplex getMovieById(@PathVariable("id") int id){
        return ms.getMultiplexById(id);
    }


}
