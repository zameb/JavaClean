package com.kipuig.eventreminder.domain.exceptions;

public class SubscriptionsLimitException extends DomainException {
    
    public SubscriptionsLimitException(int maxSubscriptions) {
        super(String.format(
            "El plan no permite más de %d subscripciones", maxSubscriptions));
    }
}
