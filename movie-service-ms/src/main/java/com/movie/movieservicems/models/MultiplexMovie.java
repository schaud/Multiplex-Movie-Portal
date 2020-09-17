package com.movie.movieservicems.models;

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
    int multiplexId;
    @Column(name = "movie")
    String movie;

    public int getMultiplexId() {
        return multiplexId;
    }

    @Override
    public String toString() {
        return "MultiplexMovie{" +
                "id=" + id +
                ", multiplex_id=" + multiplexId +
                ", movie='" + movie + '\'' +
                '}';
    }
}

