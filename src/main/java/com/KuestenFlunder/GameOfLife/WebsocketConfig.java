package com.KuestenFlunder.GameOfLife;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {
    private final GameOfLiveWebSocketHandler gameOfLiveWebSocketHandler;

    @Autowired
    public WebsocketConfig(GameOfLiveWebSocketHandler gameOfLiveWebSocketHandler) {
        this.gameOfLiveWebSocketHandler = gameOfLiveWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(gameOfLiveWebSocketHandler, "/gameoflife").setAllowedOrigins("*");
    }
}