package com.KuestenFlunder.UnitTesting;

import java.util.List;

public class GameOfLife {

    public CellState checkState(List<Boolean> neighborsState) {
        if (neighborsState.size() == 8)
            return CellState.LIST_CORRECT;
        return CellState.LIST_INCORRECT;
    }


    public enum CellState {
        LIST_CORRECT,
        LIST_INCORRECT,
        BECOME_ALIVE,
        SURVIVE,
        DEAD
    }


}
