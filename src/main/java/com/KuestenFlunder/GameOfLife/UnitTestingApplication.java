package com.KuestenFlunder.GameOfLife;

import com.KuestenFlunder.GameOfLife.Entity.Playground;
import com.KuestenFlunder.GameOfLife.Enum.CellState;
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
		Playground playground = new Playground(20, 20);
		//add blicker pattern to playground
		playground.getCellByCoordinates(7, 4).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(7, 5).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(8,6).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(6,5).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(6,6).setCellState(CellState.ALIVE);

		return playground;
	}

}
