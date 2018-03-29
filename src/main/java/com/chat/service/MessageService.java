package com.chat.service;

import com.chat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    public void sendMessage(Message message)
    {
        String user = message.getUsername();
        messageSendingOperations.convertAndSendToUser(user, "/topic/wechat", message.getContent());
    }
}
