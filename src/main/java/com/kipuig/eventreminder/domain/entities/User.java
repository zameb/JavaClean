package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.PlanTypeSubscriptionsLimitException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String email;
    private final String passwordHash;
    private final PlanType planType;
    private final List<Subscription> subscriptions;

    public User(UUID id, String email, String passwordHash,
            PlanType planType, List<Subscription> subscriptions) {

        if (email == null || !email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }

        this.id = id != null ? id : UUID.randomUUID();
        this.email = email;
        this.passwordHash = passwordHash;
        this.planType = planType;
        this.subscriptions = subscriptions != null ? subscriptions : new ArrayList<>();
    }

    public User(UUID id, String email, String passwordHash,
            PlanType planType) {
        this(id, email, passwordHash, planType, new ArrayList<>());
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) throws PlanTypeSubscriptionsLimitException {
        if (planType.getMaxSubscriptions() > subscriptions.size()) {
            throw new PlanTypeSubscriptionsLimitException(planType);
        }
        subscriptions.add(subscription);
    }
}
