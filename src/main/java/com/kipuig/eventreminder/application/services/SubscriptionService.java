package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.exceptions.PlanTypeNotFoundException;
import com.kipuig.eventreminder.domain.exceptions.UserNotFoundException;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final PlanTypeRepository planTypeRepository;

    public SubscriptionService(
            SubscriptionRepository subscriptionRepository,
            UserRepository userRepository,
            PlanTypeRepository planTypeRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.planTypeRepository = planTypeRepository;
    }

    public UUID createSubscription(UUID userId, UUID eventId) {
        var user = userRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        
        var planType = planTypeRepository.getPlanTypeById(user.getPlanTypeId())
                .orElseThrow(() -> new PlanTypeNotFoundException(user.getPlanTypeId()));

        var subscription = user.createSubscription(eventId, planType.getMaxSubscriptions());
        subscriptionRepository.save(subscription);
        return subscription.getId();
    }
}
