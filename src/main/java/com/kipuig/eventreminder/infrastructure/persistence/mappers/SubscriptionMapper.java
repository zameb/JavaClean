package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.Event;
import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.infrastructure.persistence.entities.SubscriptionEntity;

public class SubscriptionMapper {
    public static SubscriptionEntity toDataEntity(Subscription sub) {
        return new SubscriptionEntity(sub.getId(), sub.getUser().getId(), sub.getEvent().getId());
    }
    
    public static Subscription toDomain(SubscriptionEntity sub, User user, Event event) {
        return new Subscription(sub.getId(), user, event);
    }
}
