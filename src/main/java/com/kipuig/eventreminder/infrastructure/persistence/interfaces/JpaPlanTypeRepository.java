package com.kipuig.eventreminder.infrastructure.persistence.interfaces;

import com.kipuig.eventreminder.infrastructure.persistence.entities.PlanTypeEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPlanTypeRepository  extends JpaRepository<PlanTypeEntity, UUID> {
    
}
