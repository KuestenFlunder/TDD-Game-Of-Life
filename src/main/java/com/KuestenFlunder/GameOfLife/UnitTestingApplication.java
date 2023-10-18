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
		playground.getCellByCoordinates(10,7).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(9,7).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(8,7).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(8,8).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(8,9).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(9,9).setCellState(CellState.ALIVE);
		playground.getCellByCoordinates(10,9).setCellState(CellState.ALIVE);

		playground.cellField.stream().filter(cell -> cell.getCellState().equals(CellState.ALIVE)).forEach(System.out::println);

		return playground;
	}

}
