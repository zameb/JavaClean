package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void userShouldRejectSubscriptionsOutOfThePlanLimit() throws InvalidInitializationException, SubscriptionsLimitException {
        var maxSubscriptions = 3;
        var user = new User(null, "t@e.com", UUID.randomUUID());

        user.createSubscription(UUID.randomUUID(), maxSubscriptions);
        user.createSubscription(UUID.randomUUID(), maxSubscriptions);
        user.createSubscription(UUID.randomUUID(), maxSubscriptions);

        var exception = assertThrows(SubscriptionsLimitException.class,
                () -> user.createSubscription(UUID.randomUUID(), maxSubscriptions)
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithoutEmailIsRejected() {
        var planType = new PlanType(null, "FREE", 3);
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User(null, planType.getId())
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithInvalidEmailIsRejected() {
        var planType = new PlanType(null, "FREE", 3);
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User("invalid_email_value", planType.getId())
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
