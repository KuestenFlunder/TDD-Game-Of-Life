package com.KuestenFlunder.UnitTesting;

public class GameOfLiveController {
    UIOutput uiOutput;



    public void playAndSendUpdatesToUI(Playground startPlayground, int numberOfIterations) {
        for (int i = 0; i < numberOfIterations; i++) {
            startPlayground = startPlayground.getPlaygroundForNextRound();
            uiOutput.displayPlayground(startPlayground);
        }
    }
}
