package com.kipuig.eventreminder.domain.entities;

import com.kipuig.eventreminder.domain.exceptions.PlanTypeSubscriptionsLimitException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void freePlanShouldRejectSubscriptionsOutOfTheLimit() throws PlanTypeSubscriptionsLimitException {
        var planType = new PlanType(null, "FREE", 5);
        var user = new User(null, "t@e.com", planType);
        var dateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        
        List<Subscription> subscriptionList = new ArrayList(List.of(
                new Subscription(null, user, new Event(null, "Event 01", dateTime)),
                new Subscription(null, user, new Event(null, "Event 02", dateTime)),
                new Subscription(null, user, new Event(null, "Event 03", dateTime)),
                new Subscription(null, user, new Event(null, "Event 04", dateTime)),
                new Subscription(null, user, new Event(null, "Event 05", dateTime))
        ));
        user.addSubscriptionList(subscriptionList);
        var anotherSubscription = new Subscription(null, user, new Event(null, "Event 06", dateTime));

        var exception = assertThrows(PlanTypeSubscriptionsLimitException.class,
                () -> user.addSubscription(anotherSubscription)
        );

        assertFalse(exception.getMessage().isEmpty());
    }
}
