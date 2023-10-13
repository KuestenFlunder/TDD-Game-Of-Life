package com.KuestenFlunder.UnitTesting;


import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import static com.KuestenFlunder.UnitTesting.CellState.*;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Nested
    @DisplayName("test playground creation")
    class PlaygroundCreation {
        @Test
        public void create_1_cell_at_the_playground() {
            Playground playground = new Playground();

            playground.setCellField(1, 1);
            int size = playground.cellField.size();
            assertEquals(1, size);
        }

        @Test
        public void create_a_row_of_5_cells() {
            Playground playground = new Playground();

            playground.setCellField(5, 1);
            int size = playground.cellField.size();
            assertEquals(5, size);
        }

        @Test
        public void create_a_4x5_playground() {
            Playground playground = new Playground();

            playground.setCellField(5, 4);
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
    @DisplayName("test getting the state of a specific Cell")
    class GetStateOfSpecificCell{
        Playground playground;
        @BeforeEach
        public void setUp(){
            playground = new Playground(3,3);
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
    class getCellState{
        Playground playground;
        @BeforeEach
        public void setUp() {
            //default playground with only dead cells
            playground = new Playground(3, 3);
        }


        @Test
        public void all_neighbours_are_DEAD(){
            Cell acutalCell = new Cell(1,1);
            Map<CellState,Long> neighboursState = playground.getNeighboursState(acutalCell);
            assertEquals(8L,neighboursState.get(DEAD));
            assertNull(neighboursState.get(ALIVE));
        }

        @Test

        public void three_neighbours_are_ALIVE(){
            Cell actualCell = new Cell(1,1);
            playground.getCellByCoordinates(0,0).setCellState(ALIVE);
            playground.getCellByCoordinates(1,0).setCellState(ALIVE);
            playground.getCellByCoordinates(2,0).setCellState(ALIVE);

            Map<CellState,Long> result = playground.getNeighboursState(actualCell);

            assertEquals(5L,result.get(DEAD));
            assertEquals(3L,result.get(ALIVE));
        }

        @Test
        public void all_neighbours_are_ALIVE(){
            Cell actualCell = new Cell(1,1);
            playground.getCellByCoordinates(0,0).setCellState(ALIVE);
            playground.getCellByCoordinates(1,0).setCellState(ALIVE);
            playground.getCellByCoordinates(2,0).setCellState(ALIVE);

            playground.getCellByCoordinates(0,1).setCellState(ALIVE);
            playground.getCellByCoordinates(2,1).setCellState(ALIVE);

            playground.getCellByCoordinates(0,2).setCellState(ALIVE);
            playground.getCellByCoordinates(1,2).setCellState(ALIVE);
            playground.getCellByCoordinates(2,2).setCellState(ALIVE);

            Map<CellState,Long> result = playground.getNeighboursState(actualCell);

            assertNull(result.get(DEAD));
            assertEquals(8L,result.get(ALIVE));
        }

    }
}