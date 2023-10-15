package com.KuestenFlunder.GameOfLife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

	@Bean
	public Playground playground() {
		Playground playground = new Playground(10, 10);
		//add blicker pattern to playground
		playground.getCellByCoordinates(2, 1).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(2, 2).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(2, 3).setCellState(CellState.ALIVE);
		return playground;
	}
}
