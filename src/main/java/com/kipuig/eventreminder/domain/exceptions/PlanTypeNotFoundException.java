package com.kipuig.eventreminder.domain.exceptions;

import java.util.UUID;

public class PlanTypeNotFoundException extends NotFoundException {
    
    public PlanTypeNotFoundException(UUID id) {
        super(String.format("Plan Type with Id {%s} not found", id));
    }
}
