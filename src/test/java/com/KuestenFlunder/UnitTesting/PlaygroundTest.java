package com.KuestenFlunder.UnitTesting;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.KuestenFlunder.UnitTesting.CellState.ALIVE;
import static com.KuestenFlunder.UnitTesting.CellState.DEAD;
import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Nested
    @DisplayName("test playground creation")
    class PlaygroundCreation {


        @Test
        public void create_a_4x5_playground() {
            Playground playground = new Playground(4, 5);
            int size = playground.cellField.size();
            assertEquals(20, size);
        }

        @Test
        public void field_constructor_setField_of_20() {
            assertEquals(20, new Playground(5, 4).cellField.size());
        }
    }

    @Nested
    @DisplayName("test getting a cell by its coordinates")
    class GetCellByCoordinatesTests {
        @Test
        public void get_upper_left_Cell_Point_0_0() {
            Playground playground = new Playground(1, 1);

            Cell upperLeftPoint = playground.getCellByCoordinates(0, 0);

            assertEquals(new Cell(0, 0), upperLeftPoint);
        }

        @Test
        public void get_Cell_with_Point_2_2() {
            Playground playground = new Playground(3, 3);

            assertEquals(new Cell(2, 2), playground.getCellByCoordinates(2, 2));
        }

        @Test
        public void not_existing_Cell_thows_Exception() {
            Playground playground = new Playground(3, 3);
            assertThrows(NoSuchElementException.class, () -> playground.getCellByCoordinates(4, 4));
        }
    }

    @Nested
    @DisplayName("test getting a cell by its Cell object")
    class GetCellByObjectTests {
        Playground playground;

        @BeforeEach
        public void setUp() {
            playground = new Playground(3, 3);
        }

        @Test
        public void get_Cell_by_Object() {
            Cell searchedCell = new Cell(2, 2);
            Cell foundCell = playground.getCellByObject(searchedCell);

            assertEquals(searchedCell, foundCell);
        }

        @Test
        public void cell_not_present_throws_exception() {
            Cell notPresentCell = new Cell(4, 4);

            assertThrows(NoSuchElementException.class,
                    () -> playground.getCellByObject(notPresentCell));
        }

        @Test
        public void get_Cell_with_different_object_same_coordinates() {
            Cell cell1 = new Cell(2, 2);
            Cell cell2 = new Cell(2, 2); // Different object but same coordinates

            Cell foundCell = playground.getCellByObject(cell2);

            assertEquals(cell1, foundCell);
        }
    }

    @Nested
    @DisplayName("test getting the state of a specific Cell")
    class GetStateOfSpecificCell {
        Playground playground;

        @BeforeEach
        public void setUp() {
            playground = new Playground(3, 3);
        }

        @Test
        public void cell_1_1_is_DEAD() {
            Cell actualCell = new Cell(1, 1);
            assertEquals(DEAD, playground.getCellState(actualCell));
        }

        @Test
        public void cell_1_1_is_ALIVE() {
            playground = new Playground(3, 3);
            playground.getCellByCoordinates(1, 1).setCellState(ALIVE);
            Cell actualCell = playground.getCellByCoordinates(1, 1);
            assertEquals(ALIVE, playground.getCellState(actualCell));
            assertEquals(DEAD, playground.getCellByCoordinates(2, 2).getCellState());
        }
    }


    @Nested
    @DisplayName("test getting the Cell neighbours")
    class getNeighboursTests {
        Playground playground;


        @BeforeEach
        public void setUp() {
            playground = new Playground(3, 3);
        }


        @Test
        public void find_all_neighbours() {
            List<Cell> neighbours = playground.findNeighbours(new Cell(1, 1));

            assertEquals(8, neighbours.size());
            assertTrue(neighbours.contains(new Cell(0, 0)));
            assertTrue(neighbours.contains(new Cell(1, 0)));
            assertTrue(neighbours.contains(new Cell(2, 0)));

            assertTrue(neighbours.contains(new Cell(0, 1)));
            assertTrue(neighbours.contains(new Cell(2, 1)));

            assertTrue(neighbours.contains(new Cell(0, 2)));
            assertTrue(neighbours.contains(new Cell(1, 2)));
            assertTrue(neighbours.contains(new Cell(2, 2)));

        }

    }

    @Nested
    @DisplayName("test getting the state of all neighbours from a cell")
    class getCellStateOfNeighbours {
        Playground playground;

        @BeforeEach
        public void setUp() {
            //default playground with only dead cells
            playground = new Playground(3, 3);
        }


        @Test
        public void all_neighbours_are_DEAD() {
            Cell acutalCell = new Cell(1, 1);
            Map<CellState, Long> neighboursState = playground.getNeighboursState(acutalCell);
            assertEquals(8L, neighboursState.get(DEAD));
            assertEquals(0, neighboursState.get(ALIVE));
        }

        @Test
        public void three_neighbours_are_ALIVE() {
            Cell actualCell = new Cell(1, 1);
            playground.getCellByCoordinates(0, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 0).setCellState(ALIVE);

            Map<CellState, Long> result = playground.getNeighboursState(actualCell);

            assertEquals(5L, result.get(DEAD));
            assertEquals(3L, result.get(ALIVE));
        }

        @Test
        public void all_neighbours_are_ALIVE() {
            Cell actualCell = new Cell(1, 1);
            playground.getCellByCoordinates(0, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 0).setCellState(ALIVE);

            playground.getCellByCoordinates(0, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 1).setCellState(ALIVE);

            playground.getCellByCoordinates(0, 2).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 2).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 2).setCellState(ALIVE);

            Map<CellState, Long> result = playground.getNeighboursState(actualCell);

            assertEquals(0, result.get(DEAD));
            assertEquals(8L, result.get(ALIVE));
        }


        @Test
        public void corner_with_negative_nonExisting_neighbours_has_one_neighbour_alive() {
            Cell acutalCell = new Cell(0, 0);
            playground.getCellByCoordinates(0, 1).setCellState(ALIVE);

            Map<CellState, Long> result = playground.getNeighboursState(acutalCell);

            assertEquals(1L, result.get(ALIVE));
        }

        @Test
        public void corner_with_positive_nonExisting_neighbours_has_two_neighbour_alive() {
            Cell acutalCell = new Cell(2, 2);
            playground.getCellByCoordinates(1, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 1).setCellState(ALIVE);

            Map<CellState, Long> result = playground.getNeighboursState(acutalCell);

            assertEquals(2L, result.get(ALIVE));
        }
    }

    @Nested
    @DisplayName("test getting the next Cell from the Playground")
    class getNextCell {
        Playground playground;

        @BeforeEach
        public void setUp() {
            playground = new Playground(3, 3);
        }

        @Test
        public void next_Cell_form_x0y0_is_x1y0() {
            Cell actualCell = playground.getCellByCoordinates(0, 0);

            Cell nextCell = playground.getNextCell(actualCell);

            assertEquals(new Cell(1, 0), nextCell);
        }

        @Test
        public void next_Cell_from_x2y0_is_x0y1() {
            Cell actualCell = playground.getCellByCoordinates(2, 0);

            Cell nextCorrectCell = playground.getNextCell(actualCell);

            assertEquals(playground.getCellByCoordinates(0, 1), nextCorrectCell);
        }

        @Test
        public void next_Cell_from_last_Cell_return_null() {
            Cell actualCell = playground.getCellByCoordinates(2, 2);

            Cell nextCorrectCell = playground.getNextCell(actualCell);

            assertNull(nextCorrectCell);
        }

    }

    @Nested
    @DisplayName("test playground creation for the next round")
    class createNextRoundsPlayground {
        Playground playground;

        @BeforeEach
        public void setUp() {
            playground = new Playground(3, 3);
        }


        @Test
        public void cell_x1y0_is_Alive() {

            playground.getCellByCoordinates(0, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 0).setCellState(ALIVE);

            Playground resultigPlayground = playground.getPlaygroundForNextRound();
            assertEquals(DEAD, resultigPlayground.getCellByCoordinates(0, 0).getCellState());
            assertEquals(ALIVE, resultigPlayground.getCellByCoordinates(1, 1).getCellState());
            assertEquals(DEAD, resultigPlayground.getCellByCoordinates(2, 0).getCellState());
            assertEquals(DEAD, resultigPlayground.getCellByCoordinates(0, 1).getCellState());

        }


        @Test
        public void cell_x1y0_x2y0_x1y2_x2y2_are_DEAD_in_next_round() {
            playground.getCellByCoordinates(1, 0).setCellState(ALIVE);
            playground.getCellByCoordinates(0, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(2, 1).setCellState(ALIVE);
            playground.getCellByCoordinates(1, 2).setCellState(ALIVE);

            Playground resultingPlayground = playground.getPlaygroundForNextRound();

            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(0, 0).getCellState());
            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(1, 0).getCellState());
            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(2, 0).getCellState());

            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(0, 1).getCellState());
            assertEquals(DEAD, resultingPlayground.getCellByCoordinates(1, 1).getCellState());
            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(2, 1).getCellState());

            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(0, 2).getCellState());
            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(1, 2).getCellState());
            assertEquals(ALIVE, resultingPlayground.getCellByCoordinates(2, 2).getCellState());

        }


    }


}
