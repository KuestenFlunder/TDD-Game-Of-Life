package com.KuestenFlunder.GameOfLife;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameOfLiveController {
    UIOutput uiOutput;

    @GetMapping("/play/{rounds}")



    public void playAndSendUpdatesToUI(Playground startPlayground, int numberOfIterations) {
        for (int i = 0; i < numberOfIterations; i++) {
            startPlayground = startPlayground.getPlaygroundForNextRound();
            uiOutput.displayPlayground(startPlayground);
        }
    }
}
