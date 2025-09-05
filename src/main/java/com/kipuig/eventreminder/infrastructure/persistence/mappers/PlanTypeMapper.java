package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.PlanType;
import com.kipuig.eventreminder.infrastructure.persistence.entities.PlanTypeEntity;

public class PlanTypeMapper {
    public static PlanType toDomain(PlanTypeEntity planType) {
        return new PlanType(planType.getId(), planType.getName(), planType.getMaxSubscriptions());
    }
    
    public static PlanTypeEntity toDataEntity(PlanType planType) {
        return new PlanTypeEntity(planType.getId(), planType.getName(), planType.getMaxSubscriptions());
    }
}
