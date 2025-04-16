package org.example.eventorganizer.user.model;

import lombok.Builder;
import lombok.Value;
import org.example.eventorganizer.user.enums.UserRole;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link User}
 */
@Value
@Builder
public class UserDTO implements Serializable {
    UUID uuid;
    String email;
    String password;
    String name;
    String surname;
    UserRole role;
    LocalDateTime registrationDate;
    LocalDateTime lastLogin;

}