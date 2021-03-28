package com.arhscube.test.dao.mapper;

import com.arhscube.test.dao.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {

    public User toDb(com.arhscube.test.rest.model.User user) {
        if (isNull(user)) {
            return null;
        }
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public com.arhscube.test.rest.model.User toRest(User user) {
        if (isNull(user)) {
            return null;
        }
        return com.arhscube.test.rest.model.User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public List<User> toDbList(List<com.arhscube.test.rest.model.User> users) {
        if (isNull(users)) {
            return emptyList();
        }
        return users.stream().map(this::toDb).collect(toList());
    }

    public List<com.arhscube.test.rest.model.User> toRestList(List<User> users) {
        if (isNull(users)) {
            return emptyList();
        }
        return users.stream().map(this::toRest).collect(toList());
    }
}
