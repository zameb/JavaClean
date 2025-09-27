package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.domain.entities.Event;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaEventRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.EventMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Primary
public class JpaEventRepositoryImpl implements EventRepository {

    private final JpaEventRepository jpaRepository;

    public JpaEventRepositoryImpl(@Lazy JpaEventRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Mono<Event> getEventById(UUID id) {
        return jpaRepository.findById(id)
                .map(event -> EventMapper.toDomain(event));
    }

    @Override
    public Flux<Event> searchEventsByName(String name) {
        var events = jpaRepository.findByNameContainingIgnoreCase(name);
        return EventMapper.toDomain(events);
    }

    @Override
    public Mono<Event> save(Event event) {
        return jpaRepository.save(EventMapper.toPersistence(event));
    }
}
