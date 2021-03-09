package com.abac.planets.com.abac.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Crew {

    public Crew(){}

    public Crew(Integer id, String captainName, List<Robot> robots){
        this.id = id;
        this.captainName = captainName;
        this.robots = robots;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String captainName;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Robot> robots;

}
