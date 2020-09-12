package com.movie.multiplexservicems.services;

import com.movie.multiplexservicems.models.Multiplex;
import com.movie.multiplexservicems.models.MultiplexList;
import com.movie.multiplexservicems.repositories.MultiplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MultiplexService implements MultiplexServiceI {

    @Autowired
    MultiplexRepository mr;

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
}
