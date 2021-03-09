package com.abac.planets.com.abac.entity;

import com.abac.planets.util.Status;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@Builder(setterPrefix = "with")
@Entity
public class Planet {

    public Planet(){}

    public Planet(Integer id, String name,byte[] image, Status status, Crew crew){
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.crew = crew;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Lob
    private byte[] image;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Crew crew;


}
