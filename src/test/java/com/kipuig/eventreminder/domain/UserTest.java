package com.kipuig.eventreminder.domain;

import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.domain.entities.PlanType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void freePlanShouldRejectSubscriptionsOutOfTheLimit() {
        var planType = new PlanType(null, "FREE", 5);
        var subscriptionList = new ArrayList(List.of(
                new Subscription(null, "1"),
                new Subscription(null, "2"),
                new Subscription(null, "3"),
                new Subscription(null, "4"),
                new Subscription(null, "5")
        ));

        var user = new User(null, "t@e.com", "hash", planType, subscriptionList);

        var exception = assertThrows(IllegalStateException.class,
                () -> user.addSubscription(new Subscription(null, "6"))
        );

        assertFalse(exception.getMessage().isEmpty());
    }
}
