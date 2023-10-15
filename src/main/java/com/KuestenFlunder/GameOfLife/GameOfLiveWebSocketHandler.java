package com.KuestenFlunder.GameOfLife;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GameOfLiveWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private Playground playground; // Your initial playground state

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        int rounds = Integer.parseInt(message.getPayload());

        for (int i = 0; i < rounds; i++) {
            playground = playground.getPlaygroundForNextRound();
            session.sendMessage(new TextMessage(new ObjectMapper().writeValueAsString(playground)));
            Thread.sleep(500); // Sleep for half a second (or desired time) between updates
        }
    }
}
