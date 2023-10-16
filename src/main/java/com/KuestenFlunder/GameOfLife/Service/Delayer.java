package com.KuestenFlunder.GameOfLife.Service;

//add java comment

import org.springframework.stereotype.Component;

@Component
public class Delayer {

    public void delay(long millis) throws InterruptedException {

        Thread.sleep(millis);

    }
}
