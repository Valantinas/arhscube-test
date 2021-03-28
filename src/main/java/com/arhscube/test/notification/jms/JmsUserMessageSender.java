package com.arhscube.test.notification.jms;

import com.arhscube.test.notification.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Data
@Component
public class JmsUserMessageSender<T> {

    @Value("${queueName}")
    private String queueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(Event<T> event) throws JsonProcessingException {
        System.out.println("Jms Message Sender : " + event);

        final String message = objectMapper.writeValueAsString(event);
        jmsTemplate.convertAndSend(queueName, message);
    }
}