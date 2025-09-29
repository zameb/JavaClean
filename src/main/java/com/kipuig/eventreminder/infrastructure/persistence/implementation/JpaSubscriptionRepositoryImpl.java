package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaSubscriptionRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.SubscriptionMapper;
import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSubscriptionRepositoryImpl implements SubscriptionRepository {

    private final JpaSubscriptionRepository jpaSubscriptionRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public JpaSubscriptionRepositoryImpl(
            @Lazy JpaSubscriptionRepository jpaSubscriptionRepository,
            @Lazy UserRepository userRepository,
            @Lazy EventRepository eventRepository) {
        this.jpaSubscriptionRepository = jpaSubscriptionRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Subscription> getSubscriptionById(UUID id) {
    return jpaSubscriptionRepository.findById(id)
        .flatMap(subscriptionEntity ->
            userRepository.getUserById(subscriptionEntity.getUserId())
                .flatMap(user ->
                    eventRepository.getEventById(subscriptionEntity.getEventId())
                        .map(event -> SubscriptionMapper.toDomain(subscriptionEntity, user, event))
                )
        );
    }

    @Override
    public Subscription save(Subscription subscription) {
        var inserted = jpaSubscriptionRepository.save(SubscriptionMapper.toDataEntity(subscription));
        return SubscriptionMapper.toDomain(inserted, subscription.getUser(), subscription.getEvent());
    }
}
