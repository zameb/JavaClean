package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Event;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventRepository {
    Mono<Event> getEventById(UUID id);
    Flux<Event> searchEventsByName(String name);
    Mono<Event> save(Event event);
}
