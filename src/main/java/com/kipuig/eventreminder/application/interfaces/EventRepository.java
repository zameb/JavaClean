package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Event;
import java.util.List;

public interface EventRepository {
    List<Event> searchEventsByName(String name);
}
