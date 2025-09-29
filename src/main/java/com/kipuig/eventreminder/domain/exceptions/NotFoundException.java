package com.kipuig.eventreminder.domain.exceptions;

public abstract class NotFoundException extends DomainException {
    
    public NotFoundException(String message) {
        super(message);
    }
}
