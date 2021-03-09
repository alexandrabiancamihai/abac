package com.abac.planets.com.abac.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Robot {

    public Robot(){

    }

    public Robot(Integer id, String name){
        this.id  = id;
        this.name = name;
    }

    public Robot(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
