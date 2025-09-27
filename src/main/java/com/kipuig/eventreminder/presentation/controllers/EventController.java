package com.kipuig.eventreminder.presentation.controllers;

import com.kipuig.eventreminder.application.dtos.SearchEventsResponseDto;
import com.kipuig.eventreminder.application.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public Mono<SearchEventsResponseDto> GetEvents(String name) {
        return eventService.searchEventsByName(name);
    }
}
