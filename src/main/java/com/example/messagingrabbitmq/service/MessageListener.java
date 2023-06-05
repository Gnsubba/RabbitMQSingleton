package com.example.messagingrabbitmq.service;

import com.example.messagingrabbitmq.pojo.MessagePojo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class MessageListener {

    private static Logger logger = LogManager.getLogger(MessageListener.class.toString());

    @RabbitHandler
    public void eventHandler(MessagePojo message){
        logger.info("eventHandler method invoked with message: " + message.getMessage() + "by sender: "+message.getSender());
    }



}
