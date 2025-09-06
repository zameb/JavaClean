package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Event;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository {

    Optional<Event> getEventById(UUID id);

    List<Event> searchEventsByName(String name);
    
    void save(Event event);
}
