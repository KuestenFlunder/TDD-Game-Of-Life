package com.KuestenFlunder.GameOfLife;

import lombok.Getter;

import java.awt.*;
import java.util.Objects;


public class Cell {
    private final Point point = new Point();
    private CellState cellState;

    public Point getPoint() {
        return point;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Cell(int x, int y) {
        this.point.x = x;
        this.point.y = y;
        this.cellState = CellState.DEAD;
    }

    public Cell(int x, int y,CellState cellState) {
        this.point.x = x;
        this.point.y = y;
        this.cellState = cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(point, cell.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "point=" + point +
                ", cellState=" + cellState +
                '}';
    }
}
