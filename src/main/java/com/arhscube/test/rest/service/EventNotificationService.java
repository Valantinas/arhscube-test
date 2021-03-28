package com.arhscube.test.rest.service;

public interface EventNotificationService<T> {

    void notifySearched(T payload);

    void notifyCreated(T payload);

    void notifyUpdated(T payload);

    void notifyDeleted(T payload);
}
