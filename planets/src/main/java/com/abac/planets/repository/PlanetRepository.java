package com.abac.planets.repository;

import com.abac.planets.com.abac.entity.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet,Integer> {
}
