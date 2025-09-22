package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaUserRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.UserMapper;
import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryImpl(@Lazy JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(user -> UserMapper.toDomain(user));
    }

    @Override
    public void save(User user) {
        jpaUserRepository.save(UserMapper.toDataEntity(user));
    }
}
