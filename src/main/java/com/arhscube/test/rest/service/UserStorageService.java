package com.arhscube.test.rest.service;

import com.arhscube.test.rest.model.User;

import java.util.List;

public interface UserStorageService {

    User getUser(long id);

    List<User> getAllUsers();

    User addUser(User user);

    void deleteUser(long id);

    User updateUser(User user);

    void addUsers(List<User> users);
}
