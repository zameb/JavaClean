package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
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
    private final PlanTypeRepository planTypeRepository;

    public JpaUserRepositoryImpl(
            @Lazy JpaUserRepository jpaUserRepository,
            @Lazy PlanTypeRepository planTypeRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.planTypeRepository = planTypeRepository;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
    return jpaUserRepository.findById(id)
        .flatMap(userEntity ->
            planTypeRepository.getPlanTypeById(userEntity.getPlanTypeId())
                .map(plan -> UserMapper.toDomain(userEntity, plan))
        );
    }

    @Override
    public User save(User user) {
        var inserted = jpaUserRepository.save(UserMapper.toDataEntity(user));
        return UserMapper.toDomain(inserted, user.getPlanType());
    }
}
