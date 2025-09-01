package com.kipuig.eventreminder.infrastructure.persistence.interfaces;

import com.kipuig.eventreminder.infrastructure.persistence.entities.EventEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEventRepository extends JpaRepository<EventEntity, UUID> {

    List<EventEntity> findByNameContainingIgnoreCase(String name);
}
