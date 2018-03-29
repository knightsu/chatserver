package com.chat.controller;


import com.chat.model.Greet;
import com.chat.model.Message;
import com.chat.model.User;
import com.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;



@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @MessageMapping("/greeting")
    @SendToUser(value = "/topic/greet", broadcast = false)
    public Greet sayGreet(User user)
    {
        Greet greet = new Greet();
        greet.setMessage(user.getUsername() + "welcome");
        return greet;
    }


    @MessageMapping("/wechat")
    public void handleMessage(Message message)
    {
        System.out.println(message.getContent());
        messageService.sendMessage(message);
    }
}
