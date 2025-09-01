package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.Subscription;

public interface SubscriptionRepository {

    public void save(Subscription subscription);
}
