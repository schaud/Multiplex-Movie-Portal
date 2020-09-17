package com.movie.allocationservicems.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "screens")
public class MovieScreen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "multiplex_id")
    int multiplexId;
    @Column(name = "multiplex_screen_id")
    int multiplexScreenId;
    @Column(name = "movie")
    String movie;

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", multiplexId=" + multiplexId +
                ", multiplexScreenId=" + multiplexScreenId +
                ", movie='" + movie + '\'' +
                '}';
    }
}
