package com.kipuig.eventreminder.domain.exceptions;

import com.kipuig.eventreminder.domain.entities.PlanType;

public class SubscriptionsLimitException extends DomainException {
    
    public SubscriptionsLimitException(PlanType planType) {
        super(String.format(
            "El plan %s no permite más de %d subscripciones", 
            planType.getName(), planType.getMaxSubscriptions()
        ));
    }
}
