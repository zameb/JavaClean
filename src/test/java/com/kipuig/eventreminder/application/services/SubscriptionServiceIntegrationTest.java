package com.kipuig.eventreminder.application.services;

import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
import com.kipuig.eventreminder.application.interfaces.SubscriptionRepository;
import com.kipuig.eventreminder.application.interfaces.UserRepository;
import com.kipuig.eventreminder.domain.entities.Event;
import com.kipuig.eventreminder.domain.entities.PlanType;
import com.kipuig.eventreminder.domain.entities.User;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@ActiveProfiles("test")
@Transactional
public class SubscriptionServiceIntegrationTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanTypeRepository planTypeRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    private UUID userId;
    private UUID planTypeId;
    private UUID eventId;

    @BeforeEach
    public void setUp() {
        var planType = new PlanType("FREE", 3);
        planTypeRepository.save(planType);
        planTypeId = planType.getId();

        var user = new User("test@test.com", planTypeId);
        userRepository.save(user);
        userId = user.getId();
        
        var event = new Event("Evento importante", ZonedDateTime.now());
        eventId = event.getId();

        eventId = UUID.randomUUID();
    }

    @Test
    void createSubscription_WithValidData_ShouldCreateAndReturnSubscriptionId() {
        var subscriptionId = subscriptionService.createSubscription(userId, eventId);

        assertNotNull(subscriptionId);
        
        var savedSubscription = subscriptionRepository.getSubscriptionById(subscriptionId);
        assertNotNull(savedSubscription.isPresent());
        assertEquals(userId, savedSubscription.get().getUserId());
        assertEquals(eventId, savedSubscription.get().getEventId());
    }
}
