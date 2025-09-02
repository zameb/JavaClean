package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaSubscriptionRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.SubscriptionMapper;

public class JpaSubscriptionRepositoryImpl implements SubscriptionRepository {

    private final JpaSubscriptionRepository jpaRepository;

    public JpaSubscriptionRepositoryImpl(JpaSubscriptionRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Subscription subscription) {
        jpaRepository.save(SubscriptionMapper.toDataEntity(subscription));
    }
}
