package com.abac.planets.service;

import com.abac.planets.com.abac.entity.Crew;
import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.com.abac.entity.Robot;
import com.abac.planets.exception.ServiceException;
import com.abac.planets.repository.CrewRepository;
import com.abac.planets.repository.PlanetRepository;
import com.abac.planets.util.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CrewServiceImplTest {

    @Mock
    private CrewRepository crewRepository;

    @Mock
    private PlanetRepository planetRepository;

    @InjectMocks
    private CrewServiceImpl unitUnderTest;

    @Test
    public void assignCrewToPlanet_AssignsCrewToPlanetSuccessfully() throws ServiceException {
        Planet planet = setUpPlanet();
        Mockito.when(this.planetRepository.findById(planet.getId())).thenReturn(Optional.of(planet));

        Robot robot = new Robot();
        robot.setName("robotName");

        Crew crew = new Crew();
        crew.setCaptainName("captainName");
        crew.setRobots(Arrays.asList(robot));
        crew.setId(2);

        Mockito.when(this.crewRepository.findById(2)).thenReturn(Optional.of(crew));

        this.unitUnderTest.assignCrewToPlanet(planet.getId(),2 ,Status.OK);
        Mockito.verify(this.planetRepository, Mockito.times(1)).save(planet);
        assertEquals(Status.OK,planet.getStatus());
        assertEquals(2,planet.getCrew().getId());
    }

    @Test
    public void assignCrewToPlanet_throwsException_whenPlanetIsNotFound() throws ServiceException {
        Planet planet = setUpPlanet();

        Mockito.when(this.planetRepository.findById(planet.getId())).thenReturn(Optional.empty());

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            this.unitUnderTest.assignCrewToPlanet(planet.getId(),planet.getCrew().getId()
                    ,Status.OK);
        });

        Mockito.verify(this.planetRepository, Mockito.times(0)).save(planet);

    }

    private Planet setUpPlanet() {
        Robot robot = new Robot();
        robot.setName("robotName");

        Crew crew = new Crew();
        crew.setCaptainName("captainName");
        crew.setRobots(Arrays.asList(robot));
        crew.setId(1);

        return Planet.builder().withId(1).withImage(new byte[1]).withCrew(crew).withName("name").withStatus(Status.EN_ROUTE).build();
    }
}
