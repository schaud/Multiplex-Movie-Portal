package com.movie.movieservicems.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "multiplex_movies")
public class MultiplexMovie {
    @Column
    int multiplex_id;
    @Column
    String movie;


    @Override
    public String toString() {
        return "MultiplexMovie{" +
                "multiplex_id=" + multiplex_id +
                ", movie='" + movie + '\'' +
                '}';
    }
}
