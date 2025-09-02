package com.kipuig.eventreminder.domain.exceptions;

import java.util.UUID;

public class UserNotFoundException extends DomainException {
    
    public UserNotFoundException(UUID id) {
        super(String.format("No se encontro el usuario con Id {%s}", id));
    }
}
