package com.arhscube.test.dao;

import com.arhscube.test.dao.mapper.UserMapper;
import com.arhscube.test.dao.repository.UserRepository;
import com.arhscube.test.rest.model.User;
import com.arhscube.test.rest.service.UserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserStorageService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;


    public User getUser(long id) {
        return mapper.toRest(repository.getOne(id));
    }

    public List<User> getAllUsers() {
        return mapper.toRestList(repository.findAll());
    }

    public User addUser(User user) {
        return mapper.toRest(
                repository.save(mapper.toDb(user)));
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    public User updateUser(User user) {
        return mapper.toRest(
                repository.save(mapper.toDb(user)));
    }

    public void addUsers(List<User> users) {
        repository.saveAll(mapper.toDbList(users));
    }
}
