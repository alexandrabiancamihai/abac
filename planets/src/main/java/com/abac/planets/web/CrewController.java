package com.abac.planets.web;

import com.abac.planets.exception.ServiceException;
import com.abac.planets.service.CrewService;
import com.abac.planets.service.PlanetServiceImpl;
import com.abac.planets.util.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api("/crews")
@RequestMapping("/crews")
public class CrewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrewController.class);

    @Autowired
    private CrewService crewService;

    //@formatter:off

    @ApiOperation(value = "Assign a crew to a planet")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully assigned a crew to a planet"),
            @ApiResponse(code = 400, message = "Something went wrong. Could not assign a crew to a planet.")})

    //@formatter:on
    @PutMapping(value = "assignCrewToPlanet/{planetId}/{crewId}/{status}")
    public ResponseEntity assignCrewToPlanet(@PathVariable Integer planetId, @PathVariable Integer crewId, @PathVariable Status status)  {
        try {
            this.crewService.assignCrewToPlanet(planetId, crewId,status);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ServiceException e) {
            LOGGER.warn("Something went wrong. Cannot assign crew to planet.");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
