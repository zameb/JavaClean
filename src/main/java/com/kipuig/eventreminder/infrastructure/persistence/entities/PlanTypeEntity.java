package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "PlanType")
public record PlanTypeEntity(
        @Id
        UUID id,
        String name,
        int maxSubscriptions) {

}
