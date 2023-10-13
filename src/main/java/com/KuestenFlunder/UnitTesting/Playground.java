package com.KuestenFlunder.UnitTesting;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Playground {
    public List<Cell> cellField = new ArrayList<>();

    private final int xLength;
    private final int yLength;

    //expected Field orientation
    //P(0,2) P(1,2) P(2,2)
    //P(0,1) P(1,1) P(2,1)
    //P(0,0) P(1,0) P(2,0)

    public Playground(int xLenght, int yLength) {
        this.xLength = xLenght;
        this.yLength = yLength;
        setCellField(xLenght, yLength);
        System.out.println();
    }

    public void setCellField(int lengthX, int lengthY) {
        IntStream.range(0, lengthX)
                .boxed()
                .flatMap(x -> IntStream.range(0, lengthY).mapToObj(y -> new Cell(x, y)))
                .forEach(cellField::add);
    }


    public Map<CellState, Long> getNeighboursState(Cell cell) {

        return findNeighbours(cell)
                .stream()
                .map(Cell::getCellState)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()
                ));
    }

    public Cell getCellByCoordinates(int x, int y) {
        //? for better readability : deletion could be discussed
        Cell searchedCell = new Cell(x, y);

        return cellField.stream()
                .filter(cell -> cell.equals(searchedCell))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(
                                String.format("There is no Cell with the coordinates Point(%d,%d)", x, y)));
    }
    public Cell getCellByObject(Cell searchedCell) {

        int x = searchedCell.getPoint().x;
        int y = searchedCell.getPoint().y;

        return cellField.stream()
                .filter(cell -> cell.equals(searchedCell))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(
                                String.format("There is no Cell with the coordinates Point(%d,%d)", x, y)));
    }
    protected List<Cell> findNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        int x = cell.getPoint().x;
        int y = cell.getPoint().y;

        int[] xOffsets = {-1, 0, 1};
        int[] yOffsets = {-1, 0, 1};

        for (int xOffset : xOffsets) {
            for (int yOffset : yOffsets) {
                if (xOffset == 0 && yOffset == 0) {
                    continue; // Skip the current cell
                }
                int newX = x + xOffset;
                int newY = y + yOffset;
                try {
                    Cell neighborCell = getCellByCoordinates(newX, newY);
                    neighbours.add(neighborCell);
                } catch (NoSuchElementException ex) {
                    neighbours.add(new Cell(newX, newY));
                }
            }
        }
        if (neighbours.size() > 8) {
            throw new IllegalStateException("A cell cannot have more than 8 neighbors.");
        }
        return neighbours;
    }

    public CellState getCellState(Cell actualCell) {
        Cell searchedCell = getCellByCoordinates(actualCell.getPoint().x, actualCell.getPoint().y);
        return searchedCell.getCellState();
    }

    public Cell getNextCell(Cell actualCell) {
        int x = actualCell.getPoint().x;
        int y = actualCell.getPoint().y;

        if (x < xLength - 1) {
            return getCellByCoordinates(x + 1, y);
        } else if (y < yLength - 1) {
            return getCellByCoordinates(0, y + 1);
        }

        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playground that = (Playground) o;
        return xLength == that.xLength && yLength == that.yLength && Objects.equals(cellField, that.cellField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellField, xLength, yLength);
    }

}
