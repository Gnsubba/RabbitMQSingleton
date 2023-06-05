package com.example.messagingrabbitmq.service;

import com.example.messagingrabbitmq.pojo.MessagePojo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;

    private static Logger logger = LogManager.getLogger(MessageSender.class.toString());

    public void sendMessage(MessagePojo message){
        amqpTemplate.convertAndSend(queue.getName(),message);
        logger.info("Sending message to queue: " + queue.getName() + "by sender: "+ message.getSender());
    }
}
