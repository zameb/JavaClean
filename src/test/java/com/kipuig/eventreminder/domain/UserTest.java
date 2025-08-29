package com.kipuig.eventreminder.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void freePlanShouldRejectSixthSubscription() {
        var subscriptionList = new ArrayList(List.of(
                new Subscription(null, "1"),
                new Subscription(null, "2"),
                new Subscription(null, "3"),
                new Subscription(null, "4"),
                new Subscription(null, "5")
        ));

        var user = new User(null, "t@e.com", "hash", PlanType.FREE, subscriptionList);
        
        assertThrows(IllegalStateException.class,
                () -> user.addSubscription(new Subscription(null, "6"))
        );
    }
}
