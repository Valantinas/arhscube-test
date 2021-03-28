package com.arhscube.test.rest;

import com.arhscube.test.rest.model.User;
import com.arhscube.test.rest.service.EventNotificationService;
import com.arhscube.test.rest.service.UserStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

    @Autowired
    private final UserStorageService storageService;

    @Autowired
    private final EventNotificationService<User> notificationService;

    public UserController(UserStorageService storageService, EventNotificationService<User> notificationService) {
        this.storageService = storageService;
        this.notificationService = notificationService;
    }

    @GetMapping
    @ResponseStatus(value = OK)
    public List<User> getAllUsers() {

        return storageService.getAllUsers();
    }


    @GetMapping("/{id}")
    @ResponseStatus(value = OK)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {

        User user = storageService.getUser(id);
        if (nonNull(user)) {
            notificationService.notifySearched(user);
            return ResponseEntity.status(OK).body(user);
        }
        return ResponseEntity.status(NOT_FOUND).build();
    }


    @PostMapping()
    @ResponseStatus(value = CREATED)
    public User add(@RequestBody User user) {

        User created = storageService.addUser(user);
        notificationService.notifyCreated(created);

        return created;
    }


    @PutMapping()
    @ResponseStatus(value = OK)
    public User update(@RequestBody User user) {

        User updated = storageService.updateUser(user);
        notificationService.notifyUpdated(updated);

        return updated;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = NO_CONTENT)
    public void delete(@PathVariable("id") long id) {

        User user = storageService.getUser(id);

        if (nonNull(user)) {
            storageService.deleteUser(id);
            notificationService.notifyDeleted(user);
        }
    }

}
