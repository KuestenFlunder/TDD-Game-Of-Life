package com.KuestenFlunder.UnitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.KuestenFlunder.UnitTesting.CellState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SparkOfLifeTest {
    SparkOfLife sparkOfLife;

    @BeforeEach
    public void setUp() {
        sparkOfLife = new SparkOfLife();
    }

    private Map<CellState, Long> createNeighborMap(long aliveCount) {
        Map<CellState, Long> neighborMap = new HashMap<>();
        neighborMap.put(ALIVE, aliveCount);
        neighborMap.put(DEAD, 8 - aliveCount);
        return neighborMap;
    }

    @Test
    public void DEAD_cell_with_1_ALIVE_neighbors_stays_DEAD() {
        CellState state = sparkOfLife.checkStateOfActualCell(DEAD, createNeighborMap(1));
        assertEquals(DEAD, state);
    }

    @Test
    public void DEAD_cell_with_0_ALIVE_neighbors_stays_DEAD() {
        CellState state = sparkOfLife.checkStateOfActualCell(DEAD, createNeighborMap(0));
        assertEquals(DEAD, state);
    }

    @Test
    public void ALIVE_cell_with_1_ALIVE_neighbor_dies() {
        CellState state = sparkOfLife.checkStateOfActualCell(ALIVE, createNeighborMap(1));
        assertEquals(DEAD, state);
    }

    @Test
    public void DEAD_cell_with_3_ALIVE_neighbors_becomes_ALIVE() {
        CellState state = sparkOfLife.checkStateOfActualCell(DEAD, createNeighborMap(3));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_2_ALIVE_neighbors_stays_ALIVE() {
        CellState state = sparkOfLife.checkStateOfActualCell(ALIVE, createNeighborMap(2));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_3_ALIVE_neighbors_stays_ALIVE() {
        CellState state = sparkOfLife.checkStateOfActualCell(ALIVE, createNeighborMap(3));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_more_than_3_ALIVE_neighbors_becomes_dead() {
        CellState state = sparkOfLife.checkStateOfActualCell(ALIVE, createNeighborMap(4));
        assertEquals(DEAD, state);
    }
}
