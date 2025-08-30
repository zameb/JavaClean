package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.domain.entities.Event;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public Event getEventById(UUID id) {
        return new Event(null, "test", ZonedDateTime.now(ZoneId.of("UTC")));
    }

    public List<Event> searchEventsByName(String searchText) {
        return new ArrayList(List.of(
                new Event(null, "test", ZonedDateTime.now(ZoneId.of("UTC")))
        ));
    }
}
