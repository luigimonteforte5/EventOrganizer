package org.example.eventorganizer.user.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.example.eventorganizer.user.enums.UserRole;

import lombok.Builder;
import lombok.Value;

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

    List<Long> eventsOrganizedIds;
    List<Long> eventsBookedIds;
}