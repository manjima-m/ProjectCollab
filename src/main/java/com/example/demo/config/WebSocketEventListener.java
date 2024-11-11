/*package com.example.demo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

import org.springframework.web.socket.messaging.SessionDisconnectEvent;


import com.example.demo.Entity.ChatMessage;
import com.example.demo.Entity.ChatMessage.MessageType;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;

    @Autowired
   
    UserRepository userRepository;

@SuppressWarnings("null")
@EventListener
    public void handleWebSocketDisconnectListener( SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor= StompHeaderAccessor.wrap(event.getMessage());
        //@SuppressWarnings("null")
        String email=(String) ((User) headerAccessor.getSessionAttributes()).getEmail();
        if(email!=null){
            log.info("User disconnected: {}",email);
            var chatMessage = ChatMessage.builder()
            .type(MessageType.LEAVE)
            .sender(email)
            .build();
            messageTemplate.convertAndSend("/topic/public",chatMessage);
        }

    }
       
    

    
}*/