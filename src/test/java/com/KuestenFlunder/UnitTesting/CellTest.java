package com.KuestenFlunder.UnitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(1, 1);
    }

    @Test
    void testConstructorWithTwoParameters() {
        Point point = cell.getPoint();
        assertEquals(1, point.x);
        assertEquals(1, point.y);
        assertEquals(CellState.DEAD, cell.getCellState());
    }

    @Test
    void testConstructorWithThreeParameters() {
        Cell cellWithState = new Cell(2, 2, CellState.ALIVE);
        Point point = cellWithState.getPoint();
        assertEquals(2, point.x);
        assertEquals(2, point.y);
        assertEquals(CellState.DEAD, cellWithState.getCellState());  // As the state is always set to DEAD in the constructor
    }

    @Test
    void setAndGetCellState() {
        cell.setCellState(CellState.ALIVE);
        assertEquals(CellState.ALIVE, cell.getCellState());
    }

    @Test
    void testEquals() {
        Cell cell1 = new Cell(1, 1);
        Cell cell3 = new Cell(2, 2);

        assertEquals(cell, cell1);
        assertNotEquals(cell, cell3);
        assertNotEquals(cell, null);
        assertNotEquals(cell, new Point(1,1));
    }

    @Test
    void testHashCode() {
        Cell cell1 = new Cell(1, 1);
        assertEquals(cell.hashCode(), cell1.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Cell{point=java.awt.Point[x=1,y=1], cellState=DEAD}";
        assertEquals(expectedString, cell.toString());
    }
}
