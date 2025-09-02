package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.PlanType;
import java.util.Optional;
import java.util.UUID;

public interface PlanTypeRepository {
    Optional<PlanType> getPlanTypeById(UUID id);
}
