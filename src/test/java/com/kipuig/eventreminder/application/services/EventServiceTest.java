package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.domain.entities.Event;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventServiceTest {

    private final EventRepository eventRepository;
    private final EventService eventService;

    public EventServiceTest() {
        eventRepository = mock(EventRepository.class);
        eventService = new EventService(eventRepository);
    }

    @Test
    void searchEventsByName_shouldMapToDtoCorrectly() {
        var id = UUID.randomUUID();
        var dateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        var domainEvent = new Event(id, "Mi Evento", dateTime);

        when(eventRepository.searchEventsByName("Mi Evento"))
                .thenReturn(List.of(domainEvent));

        var result = eventService.searchEventsByName("Mi Evento");

        assertEquals(1, result.events().size());
        var dtoEvent = result.events().get(0);
        assertEquals(id, dtoEvent.id());
        assertEquals("Mi Evento", dtoEvent.name());
        assertEquals(dateTime, dtoEvent.dateTime());
    }
}
