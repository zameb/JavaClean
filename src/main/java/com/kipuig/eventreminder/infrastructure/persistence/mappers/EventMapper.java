package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.Event;
import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.infrastructure.persistence.entities.EventEntity;
import java.util.List;

public class EventMapper {
    public static EventEntity toPersistence(Event event) {
        return new EventEntity(event.getId(), event.getName(), event.getDateTime());
    }
    
    public static Event toDomain(EventEntity event) throws InvalidInitializationException {
        return new Event(event.id(), event.name(), event.dateTime());
    }
    
    public static List<Event> toDomain(List<EventEntity> events) {
        return (List<Event>) events.stream()
                .map(e -> toDomain(e))
                .toList();
    }
}
