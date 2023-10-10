package com.KuestenFlunder.UnitTesting;

import java.awt.*;

public class Cell {
    private Point point;
    private CellState cellState;

    public Cell(Point point) {
        this.point = point;
        this.cellState = CellState.DEAD;
    }

    public Cell(Point point, CellState cellState) {
        this.point = point;
        this.cellState = cellState;
    }

    public Point getPoint() {
        return point;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
