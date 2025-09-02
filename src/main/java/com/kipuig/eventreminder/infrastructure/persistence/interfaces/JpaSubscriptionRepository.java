package com.kipuig.eventreminder.infrastructure.persistence.interfaces;

import com.kipuig.eventreminder.infrastructure.persistence.entities.SubscriptionEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID>{
    
}
