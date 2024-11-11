package com.example.demo.Repository;



import com.example.demo.Entity.ChatMessage;
import com.example.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

    // Custom query method to retrieve chat messages between two users
    List<ChatMessage> findBySenderAndReceiverOrReceiverAndSender(User sender, User receiver, User receiver2, User sender2);
}
