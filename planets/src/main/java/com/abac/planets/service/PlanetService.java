package com.abac.planets.service;

import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.exception.ServiceException;

import java.util.List;

public interface PlanetService {

    void createPlanet(Planet planet) throws ServiceException;

    List<Planet> getAllPlanets();

    Planet findById(Integer id) throws ServiceException;
}
