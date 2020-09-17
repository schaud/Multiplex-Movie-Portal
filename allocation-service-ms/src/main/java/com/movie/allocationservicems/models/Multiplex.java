package com.movie.allocationservicems.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "multiplex")
public class Multiplex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String multiplexName;
    @Column(name = "address")
    private String address;
    @Column(name = "number_of_screens")
    private String numberOfScreens;

    @Override
    public String toString() {
        return "Multiplex{" +
                "id=" + id +
                ", multiplexName='" + multiplexName + '\'' +
                ", address='" + address + '\'' +
                ", numberOfScreens='" + numberOfScreens + '\'' +
                '}';
    }
}
