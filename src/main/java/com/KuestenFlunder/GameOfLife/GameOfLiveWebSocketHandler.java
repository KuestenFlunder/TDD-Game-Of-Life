package com.KuestenFlunder.GameOfLife;

import com.KuestenFlunder.GameOfLife.Service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GameOfLiveWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private PlaygroundService playgroundService;

    private Playground playground;
    private Playground updatedPlayground;

    @Autowired
    public GameOfLiveWebSocketHandler(Playground playground) {
        this.playground = playground;
        this.updatedPlayground = playground;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        int rounds = Integer.parseInt(message.getPayload());
        updatedPlayground = playgroundService.nextRound(playground);

        for (int i = 0; i < rounds; i++) {
            updatedPlayground = playgroundService.nextRound(updatedPlayground);
            String serializedPlayground = playgroundService.serialize(updatedPlayground);

            session.sendMessage(new TextMessage(serializedPlayground));
            Thread.sleep(500); // Sleep for half a second (or desired time) between updates
        }
    }
}
