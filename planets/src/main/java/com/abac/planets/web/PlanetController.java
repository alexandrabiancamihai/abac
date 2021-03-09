package com.abac.planets.web;

import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.exception.ServiceException;
import com.abac.planets.service.PlanetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api("/crews")
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    //@formatter:off

    @ApiOperation(value = "Retrieve all planets.", response = Planet.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved all planets")})

    //@formatter:on

    @GetMapping(path = "/getAll")
    public List<Planet> getAllPlanets(){
        return this.planetService.getAllPlanets();
    }

    //@formatter:off

    @ApiOperation(value = "Create a new planet.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully created a new planet"),
    @ApiResponse(code = 500, message = "Something went wrong. Could not create a new planet.")})

    //@formatter:on

    @PostMapping(path = "/createPlanet" ,consumes = {MediaType.APPLICATION_JSON_VALUE })
    public void createPlanet(@RequestBody Planet planet) throws ServiceException {
        this.planetService.createPlanet(planet);
    }

}
