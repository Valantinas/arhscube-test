package com.arhscube.test.notification.config;

import com.arhscube.test.notification.UserEventNotificationService;
import com.arhscube.test.rest.service.EventNotificationService;
import com.arhscube.test.rest.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EventNotificationService<User> notificationService() {
        return new UserEventNotificationService();

    }
}
