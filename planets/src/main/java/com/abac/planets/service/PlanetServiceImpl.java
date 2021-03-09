package com.abac.planets.service;

import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.exception.ServiceException;
import com.abac.planets.repository.PlanetRepository;
import com.abac.planets.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlanetServiceImpl implements PlanetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanetServiceImpl.class);

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public void createPlanet(Planet planet) throws ServiceException {
        LOGGER.info("Creating new planet...");
        if(!isStatusValid(planet.getStatus())) {
            throw  new ServiceException("Status is not correct. Please choose OK,!OK,TODO or EnRoute.");
        }

        this.planetRepository.save(planet);
    }


    @Override
    public List<Planet> getAllPlanets() {
        LOGGER.info("Getting all planets...");
       return  StreamSupport.stream(this.planetRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Planet findById(Integer id) throws ServiceException {
        Optional<Planet> planet =  this.planetRepository.findById(id);

        if(planet.isPresent()){
            LOGGER.info("Planet with id={} was found.", id);
            return  planet.get();
        } else {
            LOGGER.warn("Planet with id={} was not found", id);
            throw new ServiceException("Planet with id=" + id + "was not found");
        }
    }

    private boolean isStatusValid(Status status) throws ServiceException {
        for (Status statusValue : Status.values()) {
            if (status.getStatus().equals(statusValue.getStatus())) {
                return true;
            }
        }
        return false;
    }


}
