package com.KuestenFlunder.UnitTesting;

import org.apache.el.parser.BooleanNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {


    @Test
    public void answer_true_if_array_length_8 (){
        //arrange
        GameOfLife gameOfLife = new GameOfLife();

        //act
        GameOfLife.CellState state = gameOfLife.checkState(Arrays.asList(true,true,false,false,true,false,false));
        //assert
        assertEquals(GameOfLife.CellState.LIST_CORRECT,state);
    }

    @Test
    public void answer_false_if_array_length_notEqual8 (){
        //arrange
        GameOfLife gameOfLife = new GameOfLife();

        //act
        GameOfLife.CellState state = gameOfLife.checkState(Arrays.asList(false,false,true,false,false));
        //assert
        assertEquals(GameOfLife.CellState.LIST_INCORRECT,state);
    }



}