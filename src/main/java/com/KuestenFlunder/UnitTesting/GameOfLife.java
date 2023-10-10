package com.KuestenFlunder.UnitTesting;

import java.util.List;

public class GameOfLife {


    private static final int TOP_CONDITIONS = 3;
    private static final int GOOD_CONDITIONS = 2;


    private static long countLivingNeighbors(List<Boolean> neighborsState) {
        return neighborsState.stream().filter(value -> value).count();
    }

    private static void validateNeighborsListLenghtIsEight(List<Boolean> neighborsState) {
        if (neighborsState.size() != 8) throw new IllegalArgumentException("There should be 8 neighbours!");
    }

    public CellState checkState(CellState actualState, List<Boolean> neighbors) {
        validateNeighborsListLenghtIsEight(neighbors);
        long numberOfLivingNeighbors = countLivingNeighbors(neighbors);

        return switch ((int) numberOfLivingNeighbors) {

            case GOOD_CONDITIONS -> actualState;
            //dead cells become alive
            case TOP_CONDITIONS -> CellState.ALIVE;

            default -> CellState.DEAD;
        };
    }

    public enum CellState {
        ALIVE(true),
        DEAD(false);

        private final boolean value;

        CellState(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }


}
