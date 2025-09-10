package com.kipuig.eventreminder.presentation.controllers;

import com.kipuig.eventreminder.application.dtos.SearchEventsResponseDto;
import com.kipuig.eventreminder.application.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscriptions")
public class EventController {
    private final EventService eventService;
    
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public ResponseEntity<SearchEventsResponseDto> GetEvents(String name) {
        var events = eventService.searchEventsByName(name);
        return ResponseEntity.ok(events);
    }
}
