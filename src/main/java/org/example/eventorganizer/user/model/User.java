package org.example.eventorganizer.user.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.eventorganizer.event.model.Event;
import org.example.eventorganizer.user.enums.UserRole;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	@Builder.Default
	@ManyToMany(targetEntity = Event.class)
	@JoinTable(name = "user_event", //
			joinColumns = @JoinColumn(name = "user_id"), //
			inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> eventsBooked = new ArrayList <>();

	@Builder.Default
	@ManyToMany(targetEntity = Event.class)
	@JoinTable(name = "organizer_event", //
			joinColumns = @JoinColumn(name = "user_id"), //
			inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> eventsOrganized = new ArrayList <>();
}
