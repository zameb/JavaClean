package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.domain.exceptions.EventNotFoundException;
import com.kipuig.eventreminder.domain.exceptions.UserNotFoundException;
import java.util.UUID;

public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public SubscriptionService(
            SubscriptionRepository subscriptionRepository,
            UserRepository userRepository,
            EventRepository eventRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public Subscription createSubscription(UUID userId, UUID eventId) {
        var user = userRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        var event = eventRepository.getEventById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        var subscription = user.createSubscription(event);
        subscriptionRepository.save(subscription);
        return subscription;
    }
}
