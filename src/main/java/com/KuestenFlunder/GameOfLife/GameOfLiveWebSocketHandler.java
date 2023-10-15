package com.KuestenFlunder.GameOfLife;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GameOfLiveWebSocketHandler extends TextWebSocketHandler {

    private Playground playground;

    @Autowired
    public GameOfLiveWebSocketHandler(Playground playground) {
        this.playground = playground;
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        int rounds = Integer.parseInt(message.getPayload());

        for (int i = 0; i < rounds; i++) {
            playground = playground.computePlaygroundForNextRound();
            session.sendMessage(new TextMessage(new ObjectMapper().writeValueAsString(playground)));
            System.out.println(playground);
            System.out.println();
            Thread.sleep(50); // Sleep for half a second (or desired time) between updates
        }
    }
}
