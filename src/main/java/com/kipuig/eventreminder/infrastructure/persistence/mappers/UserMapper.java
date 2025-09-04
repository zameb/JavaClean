package com.kipuig.eventreminder.infrastructure.persistence.mappers;

import com.kipuig.eventreminder.domain.entities.User;
import com.kipuig.eventreminder.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity user) {
        return new User(user.id(), user.email(), user.planTypeId());
    }
}
