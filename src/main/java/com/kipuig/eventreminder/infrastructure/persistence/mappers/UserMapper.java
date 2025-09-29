package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.PlanType;
import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity user, PlanType planType) {
        return new User(user.getId(), user.getEmail(), planType);
    }
    
    public static UserEntity toDataEntity(User user) {
        return new UserEntity(user.getId(), user.getEmail(), user.getPlanType().getId());
    }
}
