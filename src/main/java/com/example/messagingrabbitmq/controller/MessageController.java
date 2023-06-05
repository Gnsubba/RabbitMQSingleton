package com.example.messagingrabbitmq.controller;

import com.example.messagingrabbitmq.pojo.MessagePojo;
import com.example.messagingrabbitmq.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/")
public class MessageController {

    @Autowired
    private MessageSender messageSender;

    @PostMapping("send")
    public String sendMessage(@RequestBody MessagePojo messagePojo){
        messageSender.sendMessage(messagePojo);
        return "Success";
    }
}
