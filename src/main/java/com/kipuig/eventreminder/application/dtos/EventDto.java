package com.kipuig.eventreminder.application.dtos;

import com.kipuig.eventreminder.domain.entities.Event;
import java.time.ZonedDateTime;
import java.util.UUID;

public record EventDto(UUID id, String name, ZonedDateTime dateTime) {

    public static Event toDomain(EventDto eventDto) {
        return new Event(eventDto.id, eventDto.name, eventDto.dateTime);
    }
    
    public static EventDto fromDomain(Event event) {
        return new EventDto(event.getId(), event.getName(), event.getDateTime());
    }
}
