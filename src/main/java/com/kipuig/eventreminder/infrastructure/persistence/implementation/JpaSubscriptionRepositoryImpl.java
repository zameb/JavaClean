package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaSubscriptionRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.SubscriptionMapper;
import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSubscriptionRepositoryImpl implements SubscriptionRepository {

    private final JpaSubscriptionRepository jpaRepository;

    public JpaSubscriptionRepositoryImpl(@Lazy JpaSubscriptionRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Subscription> getSubscriptionById(UUID id) {
        return jpaRepository.findById(id)
                .map(subscription -> SubscriptionMapper.toDomain(subscription));
    }

    @Override
    public void save(Subscription subscription) {
        jpaRepository.save(SubscriptionMapper.toDataEntity(subscription));
    }
}
