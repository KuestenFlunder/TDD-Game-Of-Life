package com.KuestenFlunder.GameOfLife;

import com.KuestenFlunder.GameOfLife.Enum.CellState;
import com.KuestenFlunder.GameOfLife.Service.CellSateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.KuestenFlunder.GameOfLife.Enum.CellState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CellSateServiceTest {
    CellSateService cellSateService;

    @BeforeEach
    public void setUp() {
        cellSateService = new CellSateService();
    }

    private Map<CellState, Long> createNeighborMap(long aliveCount) {
        Map<CellState, Long> neighborMap = new HashMap<>();
        neighborMap.put(ALIVE, aliveCount);
        neighborMap.put(DEAD, 8 - aliveCount);
        return neighborMap;
    }

    @Test
    public void DEAD_cell_with_1_ALIVE_neighbors_stays_DEAD() {
        CellState state = cellSateService.checkStateOfActualCell(DEAD, createNeighborMap(1));
        assertEquals(DEAD, state);
    }

    @Test
    public void DEAD_cell_with_0_ALIVE_neighbors_stays_DEAD() {
        CellState state = cellSateService.checkStateOfActualCell(DEAD, createNeighborMap(0));
        assertEquals(DEAD, state);
    }

    @Test
    public void ALIVE_cell_with_1_ALIVE_neighbor_dies() {
        CellState state = cellSateService.checkStateOfActualCell(ALIVE, createNeighborMap(1));
        assertEquals(DEAD, state);
    }

    @Test
    public void DEAD_cell_with_3_ALIVE_neighbors_becomes_ALIVE() {
        CellState state = cellSateService.checkStateOfActualCell(DEAD, createNeighborMap(3));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_2_ALIVE_neighbors_stays_ALIVE() {
        CellState state = cellSateService.checkStateOfActualCell(ALIVE, createNeighborMap(2));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_3_ALIVE_neighbors_stays_ALIVE() {
        CellState state = cellSateService.checkStateOfActualCell(ALIVE, createNeighborMap(3));
        assertEquals(ALIVE, state);
    }

    @Test
    public void ALIVE_cell_with_more_than_3_ALIVE_neighbors_becomes_dead() {
        CellState state = cellSateService.checkStateOfActualCell(ALIVE, createNeighborMap(4));
        assertEquals(DEAD, state);
    }
}
