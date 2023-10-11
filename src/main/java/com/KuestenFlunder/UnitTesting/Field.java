package com.KuestenFlunder.UnitTesting;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Field {
    public List<Cell> cellField = new ArrayList<>();

    public Field() {
    }
    //expected Field orientation
    //P(0,0) P(1,0) P(2,0)
    //P(0,1) P(1,1) P(2,1)
    //P(0,2) P(1,2) P(2,2)


    public Field(int xLenght, int yLegth) {
        setCellField(xLenght, yLegth);
        System.out.println();
    }

    public void setCellField(int lengthX, int lengthY) {
        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                cellField.add(new Cell(i, j));
            }
        }
    }

    public Cell getCellByCoordinates(int x, int y) {
        //? for better readability : deletion could be discussed
        Cell searchedCell = new Cell(x,y);

        return cellField.stream()
                .filter(cell -> cell.equals(searchedCell))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(
                                String.format("There is no Cell with the coordinates Point(%d,%d)", x, y)));
    }


}
