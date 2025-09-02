package com.kipuig.eventreminder.infrastructure.persistence.interfaces;

import com.kipuig.eventreminder.infrastructure.persistence.entities.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

}
