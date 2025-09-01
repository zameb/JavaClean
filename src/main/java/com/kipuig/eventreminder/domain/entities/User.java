package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String email;
    private final PlanType planType;
    private final List<Subscription> subscriptions;

    public User(UUID id, String email, PlanType planType, List<Subscription> subscriptions) throws InvalidInitializationException {
        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new InvalidInitializationException(User.class, "email must be valid and not null");
        }
        if (planType == null) {
            throw new InvalidInitializationException(User.class, "planType cannot be null");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.email = email;
        this.planType = planType;
        this.subscriptions = subscriptions != null ? subscriptions : new ArrayList<>();
    }

    public User(UUID id, String email, PlanType planType) throws InvalidInitializationException {
        this(id, email, planType, new ArrayList<>());
    }

    public User(String email, PlanType planType) throws InvalidInitializationException {
        this(null, email, planType, new ArrayList<>());
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) throws SubscriptionsLimitException {
        if (planType.getMaxSubscriptions() < this.subscriptions.size() + 1) {
            throw new SubscriptionsLimitException(planType);
        }
        subscriptions.add(subscription);
    }
}
