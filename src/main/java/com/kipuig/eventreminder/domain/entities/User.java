package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String email;
    private final UUID planTypeId;
    private final List<Subscription> subscriptions;

    public User(UUID id, String email, UUID planTypeId, List<Subscription> subscriptions) throws InvalidInitializationException {
        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new InvalidInitializationException(User.class, "email must be valid and not null");
        }
        if (planTypeId == null) {
            throw new InvalidInitializationException(User.class, "planTypeId cannot be null");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.email = email;
        this.planTypeId = planTypeId;
        this.subscriptions = subscriptions != null ? subscriptions : new ArrayList<>();
    }

    public User(UUID id, String email, UUID planTypeId) throws InvalidInitializationException {
        this(id, email, planTypeId, new ArrayList<>());
    }

    public User(String email, UUID planTypeId) throws InvalidInitializationException {
        this(null, email, planTypeId, new ArrayList<>());
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UUID getPlanTypeId() {
        return planTypeId;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public Subscription createSubscription(UUID eventId, int maxSubscriptions) throws SubscriptionsLimitException {
        var subscription = new Subscription(null, getId(), eventId);
        if (maxSubscriptions < this.subscriptions.size() + 1) {
            throw new SubscriptionsLimitException(maxSubscriptions);
        }
        subscriptions.add(subscription);
        return subscription;
    }
}
