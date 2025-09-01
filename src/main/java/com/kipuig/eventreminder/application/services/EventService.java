package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.dtos.SearchEventsResponseDto;
import com.kipuig.eventreminder.application.interfaces.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public SearchEventsResponseDto searchEventsByName(String name) {
        var events = eventRepository.searchEventsByName(name);
        return SearchEventsResponseDto.fromDomain(events);
    }
}
