package com.example.demo.Controller;



import com.example.demo.Entity.ChatMessage;
import com.example.demo.Service.ChatService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    // WebSocket endpoint for sending messages
    @MessageMapping("/send") // Mapping for sending messages
    @SendTo("/topic/messages") // Broadcast messages to topic
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatService.sendMessage(chatMessage.getSender().getEmail(), chatMessage.getReceiver().getEmail(), chatMessage.getContent());
    }
}*/
@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/send")
public void sendMessage(ChatMessage chatMessage) {
    // Save message to the database
    ChatMessage savedMessage = chatService.sendMessage(
        chatMessage.getSender().getEmail(),
        chatMessage.getReceiver().getEmail(),
        chatMessage.getContent()
    );

    // Send message to the sender's and receiver's private queues
    messagingTemplate.convertAndSendToUser(
        chatMessage.getSender().getEmail(),
        "/queue/messages",
        savedMessage
    );

    messagingTemplate.convertAndSendToUser(
        chatMessage.getReceiver().getEmail(),
        "/queue/messages",
        savedMessage
    );
}

}