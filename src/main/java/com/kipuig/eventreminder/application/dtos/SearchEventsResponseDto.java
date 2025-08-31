package com.kipuig.eventreminder.application.dtos;

import com.kipuig.eventreminder.domain.entities.Event;
import java.util.List;

public record SearchEventsResponseDto(List<EventDto> events) {
    public static SearchEventsResponseDto fromDomain(List<Event> events) {
        var eventDtos = events.stream()
                .map(e -> EventDto.fromDomain(e))
                .toList();

        return new SearchEventsResponseDto(eventDtos);
    }
}
