package com.movie.multiplexservicems.services;

import com.movie.multiplexservicems.models.Multiplex;
import com.movie.multiplexservicems.models.MultiplexList;
import com.movie.multiplexservicems.models.MultiplexMovie;
import com.movie.multiplexservicems.models.MultiplexMovieList;
import com.movie.multiplexservicems.repositories.MultiplexMovieRepository;
import com.movie.multiplexservicems.repositories.MultiplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class MultiplexService implements MultiplexServiceI {

    @Autowired
    MultiplexRepository mr;
    @Autowired
    MultiplexMovieRepository mmr;

    @Override
    public MultiplexList getAllMultiplexes() {
        MultiplexList multiplexList = new MultiplexList();
        List<Multiplex> multiplexListBase = mr.findAll();
        multiplexList.setMultiplexes(multiplexListBase);
        return multiplexList;
    }

    @Override
    public Multiplex getMultiplexById(int id) {
        return mr.findById(id);
    }

    @Override
    public Multiplex createMultiplex(Multiplex multiplex) {
        return mr.save(multiplex);
    }

    @Override
    public void deleteMultiplex(int id) {
        mr.delete(getMultiplexById(id));
    }

    @Override
    public Multiplex updateMultiplex(Multiplex multiplex) {
        return mr.save(multiplex);
    }

    // Allocation Services
    @Override
    public MultiplexMovieList getAllMoviesInAllMultiplexes() {
        MultiplexMovieList multiplexMovieList = new MultiplexMovieList();
        List<MultiplexMovie> multiplexMovieListBase = mmr.findAll();
        multiplexMovieList.setMovies(multiplexMovieListBase);
        return multiplexMovieList;
    }

    @Override
    public MultiplexMovie getMultiplexMovieById(int id) {
        return mmr.findById(id);
    }

    @Override
    public MultiplexMovie addMovieToMultiplex(MultiplexMovie movie) {
        return mmr.save(movie);
    }

    @Override
    public void deleteMovieFromMultiplex(int id) {
        mmr.delete(mmr.findById(id));
    }

    @Override
    public MultiplexMovieList getAllMoviesInMultiplexById(int id) {
        MultiplexMovieList multiplexMovieListById = new MultiplexMovieList();
        ArrayList<MultiplexMovie> multiplexMovieListByIdBase = new ArrayList<>();
        List<MultiplexMovie> multiplexMovieListBase = mmr.findAll();
        for (MultiplexMovie movie : multiplexMovieListBase) {
            if (movie.getMultiplexId() == id) {
                multiplexMovieListByIdBase.add(movie);
            }
        }

        multiplexMovieListById.setMovies(multiplexMovieListByIdBase);
        return multiplexMovieListById;
    }
}
