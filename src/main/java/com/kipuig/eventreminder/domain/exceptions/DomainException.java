package com.kipuig.eventreminder.domain.exceptions;

public abstract class DomainException extends Exception {
    public DomainException(String message) {
        super(message);
    }
}
