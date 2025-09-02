package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.Subscription;
import com.kipuig.eventreminder.infrastructure.persistence.entities.SubscriptionEntity;

public class SubscriptionMapper {
    public static SubscriptionEntity toDataEntity(Subscription sub) {
        return new SubscriptionEntity(sub.getId(), sub.getUserId(), sub.getEventId());
    }
}
