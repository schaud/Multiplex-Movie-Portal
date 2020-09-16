package com.movie.multiplexservicems.services;

import com.movie.multiplexservicems.models.Multiplex;
import com.movie.multiplexservicems.models.MultiplexList;


public interface MultiplexServiceI {
     MultiplexList getAllMultiplexes();
     Multiplex getMultiplexById(int id);
     Multiplex createMultiplex(Multiplex multiplex);

}
