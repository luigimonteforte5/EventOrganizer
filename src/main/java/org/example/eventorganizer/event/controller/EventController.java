package org.example.eventorganizer.event.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventorganizer.event.model.EventDTO;
import org.example.eventorganizer.event.repository.EventRepository;
import org.example.eventorganizer.event.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class EventController {
    private final EventService eventService;

    @PostMapping("/test/create/event")
    public ResponseEntity<EventDTO> createTestEvent(){
        EventDTO testEvent = eventService.createTestEvent();

        return ResponseEntity.status(HttpStatus.CREATED).body(testEvent);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getEvents(){
        List<EventDTO> events = eventService.getEvents();

        return ResponseEntity.status(HttpStatus.OK).body(events);
    }
}
