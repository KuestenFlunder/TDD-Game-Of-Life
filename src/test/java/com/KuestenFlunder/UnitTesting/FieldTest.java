package com.KuestenFlunder.UnitTesting;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

@Nested
@DisplayName("test playground creation")
class PlaygroundCreation {
    @Test
    public void set_x_side_to_size_one_playground() {
        Field field = new Field();

        field.setCellField(1, 1);
        int size = field.cellField.size();
        assertEquals(1, size);
    }

    @Test
    public void set_x_side_to_size_5_playground() {
        Field field = new Field();

        field.setCellField(5, 1);
        int size = field.cellField.size();
        assertEquals(5, size);
    }

    @Test
    public void lenght_x5_y4_result_in_fieldOf20() {
        Field field = new Field();

        field.setCellField(5, 4);
        int size = field.cellField.size();
        assertEquals(20, size);
    }

    @Test
    public void field_constructor_setField_of_20() {
        assertEquals(20, new Field(5, 4).cellField.size());
    }
}

@Nested
@DisplayName("test getting a cell by its coordinates")
class GetCellByCoordinatesTests {
    @Test
    public void get_upper_left_Cell_Point_0_0() {
        Field field = new Field(1, 1);

        Cell upperLeftPoint = field.getCellByCoordinates(0, 0);

        assertEquals(new Cell(0, 0), upperLeftPoint);
    }

    @Test
    public void get_Cell_with_Point_2_2() {
        Field field = new Field(3, 3);

        assertEquals(new Cell(2, 2), field.getCellByCoordinates(2, 2));
    }

    @Test
    public void not_existing_Cell_thows_Exception() {
        Field field = new Field(3, 3);
        assertThrows(NoSuchElementException.class, () -> field.getCellByCoordinates(4, 4));
    }
}

@Nested
    @DisplayName("test getting the Cell neighbours")
    class getNeighboursTests{
    Field field;
    @BeforeEach
    public void setUp(){
        field = new Field(3,3);
    }

    @Test
    public void get_the_neighbour_above_from_Cell_1_1(){
        List<Cell> foundNeighbour = field.findNeighbours(new Cell(1,1));

        assertTrue(foundNeighbour.contains(new Cell(1,0)));
    }

    @Test
    public void find_rowOfNeighbours_above(){
        List<Cell> upperRowOfNeighbours = field.findNeighbours(new Cell(1,1));

        assertEquals(3,upperRowOfNeighbours.size());
        assertTrue(upperRowOfNeighbours.contains(new Cell(0,0)));
        assertTrue(upperRowOfNeighbours.contains(new Cell(1,0)));
        assertTrue(upperRowOfNeighbours.contains(new Cell(2,0)));

    }



}

}