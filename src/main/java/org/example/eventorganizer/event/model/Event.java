package org.example.eventorganizer.event.model;

import java.time.LocalDateTime;
import java.util.List;

import org.example.eventorganizer.event.enums.EventStatus;
import org.example.eventorganizer.event.enums.EventType;
import org.example.eventorganizer.user.model.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	private String location;

	@Column(name = "starting_date")
	private LocalDateTime startingDate;
	@Column(name = "end_date")
	private LocalDateTime endingDate;

	@Enumerated(EnumType.STRING)
	private EventType eventType;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus;

	@Column(name = "seats_number")
	private Integer availableSeats;

	@ManyToMany(mappedBy = "eventsBooked")
	private List<User> attendees;

	@ManyToMany(mappedBy = "eventsOrganized")
	private List<User> organizers;
}
