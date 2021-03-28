package com.arhscube.test.notification.jms;

import com.arhscube.test.notification.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsUserMessageListener  {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @JmsListener(destination = "${queueName}", containerFactory = "myFactory")
    public void receiveMessage(String message) throws JsonProcessingException {

        Event event = objectMapper.readValue(message, Event.class);
        System.out.println(event);
    }
}