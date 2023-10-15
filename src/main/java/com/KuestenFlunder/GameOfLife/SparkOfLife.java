package com.KuestenFlunder.GameOfLife;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

import static com.KuestenFlunder.GameOfLife.CellState.ALIVE;


public class SparkOfLife {


    private static final int TOP_CONDITIONS = 3;

    private static final int GOOD_CONDITIONS = 2;


    public CellState checkStateOfActualCell(CellState actualState, Map<CellState,Long> neighborsState) {

        long numberOfLivingNeighbors = neighborsState.get(ALIVE);

        return switch ((int) numberOfLivingNeighbors) {

            case GOOD_CONDITIONS -> actualState;
            //dead cells become alive
            case TOP_CONDITIONS -> ALIVE;

            default -> CellState.DEAD;
        };
    }


}
