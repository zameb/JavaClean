package com.kipuig.eventreminder.domain.exceptions;

public class InvalidInitializationException extends DomainException {
    public InvalidInitializationException(Class<?> type, String reason) {
        super(String.format("No se pudo inicializar %s (%s).", type.getSimpleName(), reason));
    }
}
