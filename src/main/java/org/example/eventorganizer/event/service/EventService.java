package org.example.eventorganizer.event.service;

import lombok.RequiredArgsConstructor;
import org.example.eventorganizer.event.enums.EventStatus;
import org.example.eventorganizer.event.enums.EventType;
import org.example.eventorganizer.event.model.Event;
import org.example.eventorganizer.event.model.EventDTO;
import org.example.eventorganizer.event.repository.EventRepository;
import org.example.eventorganizer.mapper.impl.EventMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.example.eventorganizer.event.enums.EventStatus.IN_PROCESS;
import static org.example.eventorganizer.event.enums.EventType.CONCERT;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public List<EventDTO> getEvents() {
        return eventRepository.findAll().stream().map(eventMapper::toDto).toList();
    }

    public EventDTO createTestEvent() {
        EventDTO event = eventConstructor("Test Event", "Test Description", "Test Location", CONCERT, IN_PROCESS, LocalDateTime.now(), LocalDateTime.now(), 300);

        return updateAndGetEventDTO(event);
    }

    private EventDTO eventConstructor(String title, String description, String location, EventType eventType, EventStatus eventStatus,
                                      LocalDateTime startDate, LocalDateTime endDate, Integer availableSeats) {
        Event event = Event.builder()
                .title(title)
                .location(location)
                .eventStatus(eventStatus)
                .eventType(eventType)
                .description(description)
                .startingDate(startDate)
                .endingDate(endDate)
                .availableSeats(availableSeats)
                .build();

        return eventMapper.toDto(event);
    }

    private EventDTO updateAndGetEventDTO(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        updateEvent(event);

        return eventDTO;
    }

    private void updateEvent(Event event) {
        eventRepository.save(event);
    }
}
