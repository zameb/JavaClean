package com.kipuig.eventreminder.domain.exceptions;

import java.util.UUID;

public class EventNotFoundException extends DomainException {
    
    public EventNotFoundException(UUID id) {
        super(String.format("No se encontro el evento con Id {%s}", id));
    }
}
