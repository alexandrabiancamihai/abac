package com.abac.planets;

import com.abac.planets.com.abac.entity.Crew;
import com.abac.planets.com.abac.entity.Planet;
import com.abac.planets.com.abac.entity.Robot;
import com.abac.planets.repository.CrewRepository;
import com.abac.planets.repository.PlanetRepository;
import com.abac.planets.util.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class PlanetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetsApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.abac.planets")).build();
	}



	@Bean
	public CommandLineRunner runner(PlanetRepository planetRepository){
		return args -> {
			Robot robot = new  Robot();
			robot.setName("robotName");
			Crew crew = new Crew();
			crew.setCaptainName("captainName");
			crew.setRobots(Arrays.asList(robot));

			planetRepository.save(Planet.builder().withCrew(crew).withName("name").withStatus(Status.TODO).withImage(new byte[0]).build());


		};
	}

}
