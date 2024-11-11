package com.example.demo.Service;



import com.example.demo.Entity.ChatMessage;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ChatMessageRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private com.example.demo.Repository.UserRepository userRepository;

    public ChatMessage sendMessage(String senderEmail, String receiverEmail, String content) {
        User sender = userRepository.findByEmail(senderEmail);
        User receiver = userRepository.findByEmail(receiverEmail);

        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(String senderEmail, String receiverEmail) {
        User sender = userRepository.findByEmail(senderEmail);
        User receiver = userRepository.findByEmail(receiverEmail);

        return chatMessageRepository.findBySenderAndReceiverOrReceiverAndSender(sender, receiver, receiver, sender);
    }
}
