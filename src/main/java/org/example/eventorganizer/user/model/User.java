package org.example.eventorganizer.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.eventorganizer.user.enums.UserRole;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "uuid", columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID uuid;

    private String email;
    private String password;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String surname;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime registrationDate;
    @Column(name = "last_access_date")
    private LocalDateTime lastLogin;
}
