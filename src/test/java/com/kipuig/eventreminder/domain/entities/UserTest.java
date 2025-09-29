package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void userShouldRejectSubscriptionsOutOfThePlanLimit() throws InvalidInitializationException, SubscriptionsLimitException {
        var maxSubscriptions = 3;
        var planType = new PlanType("Test Plan Type", maxSubscriptions);
        var user = new User("t@e.com", planType);
        
        var event1 = new Event("Mundial de Clubes", ZonedDateTime.parse("2025-09-28T14:30:00Z"));
        var event2 = new Event("Sorteo del Mundial de fútbol", ZonedDateTime.parse("2025-09-28T14:30:00Z"));
        var event3 = new Event("Gala del Balón de Oro", ZonedDateTime.parse("2025-09-28T14:30:00Z"));
        var event4 = new Event("Superbowl", ZonedDateTime.parse("2025-09-28T14:30:00Z"));

        user.createSubscription(event1);
        user.createSubscription(event2);
        user.createSubscription(event3);

        var exception = assertThrows(SubscriptionsLimitException.class,
                () -> user.createSubscription(event4)
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithoutEmailIsRejected() {
        var planType = new PlanType("FREE", 3);
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User(null, planType)
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithInvalidEmailIsRejected() {
        var planType = new PlanType("FREE", 3);
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User("invalid_email_value", planType)
        );

        assertFalse(exception.getMessage().isEmpty());
    }
    
    @Test
    void userWithoutPlanTypeIsRejected() {
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User("valid_email@hotmail.com", null)
        );

        assertFalse(exception.getMessage().isEmpty());
    }
}
