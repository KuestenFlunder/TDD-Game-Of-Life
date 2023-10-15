package com.KuestenFlunder.UnitTesting;

public class GameOfLiveController {
    UIOutput uiOutput;

    public void playAndSendUpdatesToUI(Playground startPlayground, int numberOfIterations) {
        uiOutput.displayPlayground(startPlayground);
    }
}
