package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.PlanType;
import java.util.UUID;

public interface PlanTypeRepository {
    PlanType getPlanTypeById(UUID id);
}
