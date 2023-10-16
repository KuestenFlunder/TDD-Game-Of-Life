package com.KuestenFlunder.GameOfLife.Enum;

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

