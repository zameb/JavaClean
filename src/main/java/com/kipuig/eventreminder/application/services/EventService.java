package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.dtos.EventDto;
import com.kipuig.eventreminder.application.dtos.SearchEventsResponseDto;
import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.mappers.EventMapper;
import java.util.UUID;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Mono<SearchEventsResponseDto> searchEventsByName(String name) {
        log.info("Searching events by name: {}", name);
        var events = eventRepository.searchEventsByName(name);
        return events
                .map(e -> EventMapper.toDto(e)).collectList()
                .map(el -> new SearchEventsResponseDto(el));
    }
    
    public Mono<UUID> CreateEvent(EventDto eventDto) 
    {
        var event = EventMapper.toDomain(eventDto);
        return eventRepository.save(event)
                .map(e -> e.getId());
    }
}
