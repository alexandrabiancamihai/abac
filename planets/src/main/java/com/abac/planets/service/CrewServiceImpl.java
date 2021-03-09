package com.abac.planets.service;

import com.abac.planets.com.abac.entity.Crew;
import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.exception.ServiceException;
import com.abac.planets.repository.CrewRepository;
import com.abac.planets.repository.PlanetRepository;
import com.abac.planets.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrewServiceImpl implements  CrewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrewServiceImpl.class);

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public void assignCrewToPlanet(Integer planetId, Integer crewId, Status status) throws ServiceException {
        LOGGER.info("Assigning crew to planet...");
        Optional<Planet> planet = this.planetRepository.findById(planetId);
        Optional<Crew> crew = this.crewRepository.findById(crewId);

        if(planet.isPresent() && crew.isPresent()){
            planet.get().setCrew(crew.get());
            planet.get().setStatus(status);
            this.planetRepository.save(planet.get());
            LOGGER.info("Successfully assigned crew to planet.");
        } else {
            LOGGER.warn("Planet with id={} was not found. Cannot assign crew to planet.", planetId);
            throw new ServiceException("Planet with id={} was not found. Cannot assign crew to planet.");
        }



    }
}
