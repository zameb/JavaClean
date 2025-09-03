package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.dtos.EventDto;
import com.kipuig.eventreminder.application.dtos.SearchEventsResponseDto;
import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.mappers.EventMapper;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public SearchEventsResponseDto searchEventsByName(String name) {
        var events = eventRepository.searchEventsByName(name);
        return new SearchEventsResponseDto(EventMapper.toDto(events));
    }
    
    public UUID CreateEvent(EventDto eventDto) 
    {
        var event = EventMapper.toDomain(eventDto);
        eventRepository.save(event);
        return event.getId();
    }
}
