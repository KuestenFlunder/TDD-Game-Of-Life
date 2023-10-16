package com.KuestenFlunder.GameOfLife.Service;

import com.KuestenFlunder.GameOfLife.CellState;
import com.KuestenFlunder.GameOfLife.Playground;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.KuestenFlunder.GameOfLife.CellState.ALIVE;
import static org.junit.jupiter.api.Assertions.*;

class PlaygroundServiceTest {
    private Playground playground;
    private PlaygroundService playgroundService = new PlaygroundService();
    @BeforeEach
    void setUp() {
        playground = new Playground(3,3);
    //add blinker
        playground.getCellByCoordinates(1,0).setCellState(ALIVE);
        playground.getCellByCoordinates(1,1).setCellState(ALIVE);
        playground.getCellByCoordinates(1,2).setCellState(ALIVE);

    }

    @Test
    public void return_negative_blinker_next_round() {

        Playground resultingPlayground = playgroundService.nextRound(playground);

        assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(0,1).getCellState());
        assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(1,1).getCellState());
        assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(2,1).getCellState());
    }




}