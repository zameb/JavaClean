package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.SubscriptionsLimitException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void freePlanShouldRejectSubscriptionsOutOfTheLimit() throws SubscriptionsLimitException {
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
}
