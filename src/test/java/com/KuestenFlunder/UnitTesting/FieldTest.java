package com.KuestenFlunder.UnitTesting;


import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldTest {


    @Test
    public void set_x_side_to_size_one_playground() {
        Field field = new Field();

        field.setCellField(1, 0);
        int size = field.cellField.size();
        assertEquals(1, size);
    }

    @Test
    public void set_x_side_to_size_5_playground() {
        Field field = new Field();

        field.setCellField(5, 0);
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

    @Test
    public void get_upper_left_Cell_Point_0_0() {
        Field field = new Field(1, 1);

        Cell upperLeftPoint = field.getCellByPoint(0, 0);

        assertEquals(new Cell(0,0), upperLeftPoint);
    }

    @Test
    public void get_Cell_with_Point_2_2() {
        Field field = new Field(3, 3);

        Cell askedCell = field.getCellByPoint(2,2);

        assertEquals(new Cell(2,2),askedCell);
    }


}