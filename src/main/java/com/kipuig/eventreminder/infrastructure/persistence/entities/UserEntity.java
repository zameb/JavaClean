package com.kipuig.eventreminder.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "User")
public record UserEntity(
        @Id
        UUID id,
        String email,
        UUID planTypeId) {

}
