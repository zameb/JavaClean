package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Subscription;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {
    public Optional<Subscription> getSubscriptionById(UUID id);
    public void save(Subscription subscription);
}
