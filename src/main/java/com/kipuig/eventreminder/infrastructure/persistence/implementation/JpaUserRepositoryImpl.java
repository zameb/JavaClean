package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaUserRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.UserMapper;
import java.util.UUID;

public class JpaUserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User getUserById(UUID id) {
        var userEntity = jpaUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UserMapper.toDomain(userEntity);
    }
}
