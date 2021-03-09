package com.abac.planets.service;

import com.abac.planets.exception.ServiceException;
import com.abac.planets.util.Status;

public interface CrewService {

    void assignCrewToPlanet(Integer planetId, Integer crewId, Status status) throws ServiceException;
}
