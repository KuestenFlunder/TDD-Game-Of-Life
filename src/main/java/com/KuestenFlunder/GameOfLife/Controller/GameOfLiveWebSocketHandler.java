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

    private PlaygroundService playgroundService;
    private Delayer delayer;
    private Playground playground;
    private Playground updatedPlayground;

    @Autowired
    public GameOfLiveWebSocketHandler(Playground playground, PlaygroundService playgroundService, Delayer delayer) {
        this.playground = playground;
        this.updatedPlayground = playground;
        this.playgroundService = playgroundService;
        this.delayer = delayer;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        int rounds = Integer.parseInt(message.getPayload());

        //send back the initial playground to show the user the initial state
        String initialSerializedPlayground = playgroundService.serialize(playground);
        session.sendMessage(new TextMessage(initialSerializedPlayground));
        delayer.delay(200);

        //send back the updated playground for each round
        for (int i = 0; i < rounds; i++) {
            updatedPlayground = playgroundService.nextRound(updatedPlayground);
            String serializedPlayground = playgroundService.serialize(updatedPlayground);

            session.sendMessage(new TextMessage(serializedPlayground));
            delayer.delay(500);
        }
    }
}
