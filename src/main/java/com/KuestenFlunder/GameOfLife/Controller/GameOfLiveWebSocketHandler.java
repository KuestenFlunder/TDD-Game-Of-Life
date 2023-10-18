package com.KuestenFlunder.GameOfLife.Controller;

import com.KuestenFlunder.GameOfLife.Entity.Playground;
import com.KuestenFlunder.GameOfLife.Service.Delayer;
import com.KuestenFlunder.GameOfLife.Service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameOfLiveWebSocketHandler extends TextWebSocketHandler {

    private final PlaygroundService playgroundService;
    private final Delayer delayer;
    private final Playground initialPlayground;

    @Autowired
    public GameOfLiveWebSocketHandler(Playground playground, PlaygroundService playgroundService, Delayer delayer) {
        this.initialPlayground = playground;
        this.playgroundService = playgroundService;
        this.delayer = delayer;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        int rounds = Integer.parseInt(message.getPayload());
        Playground currentPlayground = initialPlayground;

        // Send back the initial playground to show the user the initial state
        String serializedPlayground = playgroundService.serialize(currentPlayground);
        session.sendMessage(new TextMessage(serializedPlayground));
        delayer.delay(200);

        // Send back the updated playground for each round
        for (int i = 0; i < rounds; i++) {
            currentPlayground = playgroundService.nextRound(currentPlayground);
            serializedPlayground = playgroundService.serialize(currentPlayground);

            session.sendMessage(new TextMessage(serializedPlayground));
            delayer.delay(500);
        }
    }
}
