package com.kipuig.eventreminder.application.mappers;

import com.kipuig.eventreminder.application.dtos.EventDto;
import com.kipuig.eventreminder.domain.entities.Event;
import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import java.util.List;

public class EventMapper {

    public static Event toDomain(EventDto eventDto) throws InvalidInitializationException {
        return new Event(eventDto.id(), eventDto.name(), eventDto.dateTime());
    }

    public static EventDto toDto(Event event) {
        return new EventDto(event.getId(), event.getName(), event.getDateTime());
    }

    public static List<EventDto> toDto(List<Event> events) {
        var eventDtos = events.stream()
                .map(e -> EventMapper.toDto(e))
                .toList();

        return eventDtos;
    }
}
