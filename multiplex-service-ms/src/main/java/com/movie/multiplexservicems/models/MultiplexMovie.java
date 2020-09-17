package com.movie.multiplexservicems.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "multiplex_movies")
public class MultiplexMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "multiplex_id")
    int multiplex_id;
    @Column(name = "movie")
    String movie;

    public int getMultiplex_id() {
        return multiplex_id;
    }

    @Override
    public String toString() {
        return "MultiplexMovie{" +
                "id=" + id +
                ", multiplex_id=" + multiplex_id +
                ", movie='" + movie + '\'' +
                '}';
    }
}
