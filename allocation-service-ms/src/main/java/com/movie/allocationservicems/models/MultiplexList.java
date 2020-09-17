package com.movie.allocationservicems.models;


import java.util.List;

public class MultiplexList {

    public List<Multiplex>  multiplexes;

    public MultiplexList(List<Multiplex> multiplexes) {
        this.multiplexes = multiplexes;
    }

    public MultiplexList() {

    }

    public List<Multiplex> getMultiplexes() {
        return multiplexes;
    }

    public void setMultiplexes(List<Multiplex> multiplexes) {
        this.multiplexes = multiplexes;
    }

}
