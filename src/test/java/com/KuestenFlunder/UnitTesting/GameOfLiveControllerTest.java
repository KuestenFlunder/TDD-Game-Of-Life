package com.KuestenFlunder.UnitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) //!causes: OpenJDK 64-Bit Server VM warning (can so far been ignored)
class GameOfLiveControllerTest {

    @Mock
    UIOutput uiOutput;
    @InjectMocks
    GameOfLiveController gameOfLiveController;
    private Playground startPlayground;

    @Test
    public void intiTest() {
        assertTrue(true);
    }

    @BeforeEach
    public void setUp() {
        startPlayground = new Playground(3, 3);
    }

    @Test
    public void call_UIOutput_once() {
        gameOfLiveController.playAndSendUpdatesToUI(startPlayground,1);
        verify(uiOutput,times(1)).displayPlayground(startPlayground);
    }



}