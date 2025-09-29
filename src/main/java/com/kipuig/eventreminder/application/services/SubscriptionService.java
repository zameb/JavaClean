package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.interfaces.EventRepository;
import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.exceptions.EventNotFoundException;
import com.kipuig.eventreminder.domain.exceptions.PlanTypeNotFoundException;
import com.kipuig.eventreminder.domain.exceptions.UserNotFoundException;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
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

    public UUID createSubscription(UUID userId, UUID eventId) {
        var user = userRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        
        var event = eventRepository.getEventById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        var subscription = user.createSubscription(event);
        subscriptionRepository.save(subscription);
        return subscription.getId();
    }
}
