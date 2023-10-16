package com.KuestenFlunder.GameOfLife.Service;

import com.KuestenFlunder.GameOfLife.Playground;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {

    public Playground nextRound(Playground currendPlayground) {
        return currendPlayground.computePlaygroundForNextRound();
    }
}
