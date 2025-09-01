package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Event;
import java.util.List;
import java.util.UUID;

public interface EventRepository {

    Event getEventById(UUID id);

    List<Event> searchEventsByName(String name);
}
