package com.KuestenFlunder.UnitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameOfLifeTest {
    GameOfLife gameOfLife;

    @BeforeEach
    public void setUp() {
        //arrange
        gameOfLife = new GameOfLife();
    }

    @Test
    public void answer_LIST_INCORRECT_if_array_length_notEqual8() {
        assertThrows(IllegalArgumentException.class,() -> gameOfLife.checkState(GameOfLife.CellState.DEAD,Arrays.asList(false, false, true, false, false)));
    }

    @Test
    public void DEAD_cell_with_0_neighbors_stays_DEAD() {
        //act
        GameOfLife.CellState state = gameOfLife.checkState(GameOfLife.CellState.DEAD,Arrays.asList(false,false,false,false,false,false,false,false));
        assertEquals(GameOfLife.CellState.DEAD,state);
    }

    @Test
    public void anser_DEAD_if_array_contains_1_neighbors() {
        //act
        GameOfLife.CellState state = gameOfLife.checkState(GameOfLife.CellState.DEAD,Arrays.asList(true,false,false,false,false,false,false,false));
        assertEquals(GameOfLife.CellState.DEAD,state);
    }




}