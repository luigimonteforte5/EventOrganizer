package org.example.eventorganizer.event.model;

import lombok.Value;
import org.example.eventorganizer.event.enums.EventStatus;
import org.example.eventorganizer.event.enums.EventType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Event}
 */
@Value
public class EventDTO implements Serializable {
    String title;
    String description;
    String location;
    LocalDateTime startingDate;
    LocalDateTime endingDate;
    EventType eventType;
    EventStatus eventStatus;
    Integer availableSeats;
}