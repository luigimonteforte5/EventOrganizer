package org.example.eventorganizer.event.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.example.eventorganizer.event.enums.EventStatus;
import org.example.eventorganizer.event.enums.EventType;

import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link Event}
 */
@Value
@Builder
public class EventDTO implements Serializable {
	String title;
	String description;
	String location;
	LocalDateTime startingDate;
	LocalDateTime endingDate;
	EventType eventType;
	EventStatus eventStatus;
	Integer availableSeats;

	List<Long> organizerIds;
	List<Long> attendeeIds;
}