package org.eci;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configuración del broker para manejar mensajes STOMP
        config.enableSimpleBroker("/topic"); // Prefijo para mensajes enviados al cliente
        config.setApplicationDestinationPrefixes("/app"); // Prefijo para mensajes enviados al servidor
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // Cambia "/wss" por "/ws" (más estándar)
                .setAllowedOriginPatterns("http://localhost:3000") // Reemplaza por tu dominio
                .withSockJS(); // Habilita soporte para SockJS
    }
}