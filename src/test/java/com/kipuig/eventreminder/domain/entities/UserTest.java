package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.InvalidInitializationException;
import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void userShouldRejectSubscriptionsOutOfThePlanLimit() throws InvalidInitializationException, SubscriptionsLimitException {
        var planType = new PlanType(null, "FREE", 3);
        var user = new User(null, "t@e.com", planType);
        var dateTime = ZonedDateTime.now(ZoneId.of("UTC"));

        user.addSubscription(new Subscription(null, user, new Event(null, "Event 01", dateTime)));
        user.addSubscription(new Subscription(null, user, new Event(null, "Event 02", dateTime)));
        user.addSubscription(new Subscription(null, user, new Event(null, "Event 03", dateTime)));

        var anotherSubscription = new Subscription(null, user, new Event(null, "Event 04", dateTime));

        var exception = assertThrows(SubscriptionsLimitException.class,
                () -> user.addSubscription(anotherSubscription)
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithoutEmailIsRejected() {
        var planType = new PlanType(null, "FREE", 3);
        var exception = assertThrows(InvalidInitializationException.class,
                () -> new User(null, planType)
        );

        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    void userWithInvalidEmailIsRejected() {
        var planType = new PlanType(null, "FREE", 3);
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
