package com.KuestenFlunder.GameOfLife.Service;

import com.KuestenFlunder.GameOfLife.Entity.Playground;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {

    public final ObjectMapper objectMapper = new ObjectMapper();

    public Playground nextRound(Playground currendPlayground) {
        return currendPlayground.computePlaygroundForNextRound();
    }

    public String serialize(Playground playground) throws Exception {

        return objectMapper.writeValueAsString(playground);

    }
}
