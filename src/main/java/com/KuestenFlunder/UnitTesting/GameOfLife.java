package com.KuestenFlunder.UnitTesting;

import java.util.List;

public class GameOfLife {
    public CellState checkState(CellState actualState,List<Boolean> neighborsState) {
        if (neighborsState.size() != 8)
           throw new IllegalArgumentException("There should be 8 neighbours!");
        return CellState.DEAD;
    }

    public enum CellState {
        BORN,
        ALIVE,
        DEAD
    }


}
