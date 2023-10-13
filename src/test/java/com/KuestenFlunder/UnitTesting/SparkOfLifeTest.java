package com.KuestenFlunder.UnitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SparkOfLifeTest {
    SparkOfLife sparkOfLife;

    @BeforeEach
    public void setUp() {
        //arrange
        sparkOfLife = new SparkOfLife();
    }

    @Test
    public void answer_LIST_INCORRECT_if_array_length_notEqual8() {
        assertThrows(IllegalArgumentException.class,() -> sparkOfLife.checkStateOfActualCell(CellState.DEAD,Arrays.asList(false, false, true, false, false)));
    }

    @Test
    public void DEAD_cell_with_1_ALIVE_neighbors_stays_DEAD() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.DEAD,Arrays.asList(true,false,false,false,false,false,false,false));
        assertEquals(CellState.DEAD,state);
    }

    @Test
    public void DEAD_cell_with_0_ALIVE_neighbors_stays_DEAD() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.DEAD,Arrays.asList(false,false,false,false,false,false,false,false));
        assertEquals(CellState.DEAD,state);
    }

    //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    @Test
    public void ALIVE_cell_with_1_ALIVE_neighbor_dies(){
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.ALIVE,Arrays.asList(true,false,false,false,false,false,false,false));
    }

    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void DEAD_cell_with_3_ALIVE_neighbors_becomes_ALIVE() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.DEAD,Arrays.asList(true,true,true,false,false,false,false,false));
        assertEquals(CellState.ALIVE,state);
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void ALIVE_cell_with_2_ALIVE_neighbors_stays_ALIVE() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.ALIVE,Arrays.asList(true,true,false,false,false,false,false,false));
        assertEquals(CellState.ALIVE,state);
    }

    @Test
    public void ALIVE_cell_with_3_ALIVE_neighbors_stays_ALIVE() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.ALIVE,Arrays.asList(true,true,true,false,false,false,false,false));
        assertEquals(CellState.ALIVE,state);
    }

    //Any live cell with more than three live neighbours dies, as if by overpopulation.
    @Test
    public void ALIVE_cell_with_more_than_3_ALIVE_neighbors_becomes_dead() {
        //act
        CellState state = sparkOfLife.checkStateOfActualCell(CellState.ALIVE,Arrays.asList(true,true,true,true,false,false,false,false));
        assertEquals(CellState.DEAD,state);
    }
}
