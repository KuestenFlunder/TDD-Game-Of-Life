package com.KuestenFlunder.UnitTesting;

import java.util.List;

public class GameOfLife {
    private static long countLivingNeighbors(List<Boolean> neighborsState) {
        return neighborsState.stream().filter(value -> value).count();
    }

    public CellState checkState(CellState actualState, List<Boolean> neighbors) {
        validateNeighborsListLenghtIsEight(neighbors);
        long numberOfLivingNeighbors = countLivingNeighbors(neighbors);

        return switch ((int) numberOfLivingNeighbors) {
            case 2 -> actualState;
            case 3 -> CellState.ALIVE;
            default -> CellState.DEAD;
        };
    }

    private static void validateNeighborsListLenghtIsEight(List<Boolean> neighborsState) {
        if (neighborsState.size() != 8) throw new IllegalArgumentException("There should be 8 neighbours!");
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
