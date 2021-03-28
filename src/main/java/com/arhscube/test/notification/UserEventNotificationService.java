package com.arhscube.test.notification;

import com.arhscube.test.notification.jms.JmsUserMessageSender;
import com.arhscube.test.notification.model.Event;
import com.arhscube.test.rest.service.EventNotificationService;
import com.arhscube.test.rest.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventNotificationService implements EventNotificationService<User> {

    @Autowired
    private JmsUserMessageSender<User> jmsUserMessageSender;

    @Override
    public void notifySearched(User user) {
        try {
            jmsUserMessageSender.sendMessage(Event.<User>builder()
                    .payload(user)
                    .eventDescription("user searched")
                    .build());
        } catch (JsonProcessingException e) {
            System.out.println("failed to send search notification");
        }
    }

    @Override
    public void notifyCreated(User user) {
        try {
            jmsUserMessageSender.sendMessage(Event.<User>builder()
                    .payload(user)
                    .eventDescription("user created")
                    .build());
        } catch (JsonProcessingException e) {
            System.out.println("failed to send create notification");
        }
    }

    @Override
    public void notifyUpdated(User user) {
        try {
            jmsUserMessageSender.sendMessage(Event.<User>builder()
                    .payload(user)
                    .eventDescription("user updated")
                    .build());
        } catch (JsonProcessingException e) {
            System.out.println("failed to send update notification %s");
        }
    }

    @Override
    public void notifyDeleted(User user) {
        try {
            jmsUserMessageSender.sendMessage(Event.<User>builder()
                    .payload(user)
                    .eventDescription("user deleted")
                    .build());
        } catch (JsonProcessingException e) {
            System.out.println("failed to send delete notification");
        }
    }
}
