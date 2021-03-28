package com.arhscube.test.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return String.format("User{id=%s, firstName=%s, lastName=%s, email=%s}",
                getId(), getFirstName(), getLastName(), getEmail());
    }
}
