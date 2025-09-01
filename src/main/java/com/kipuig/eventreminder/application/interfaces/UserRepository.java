package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.User;
import java.util.UUID;

public interface UserRepository {
    User getUserById(UUID id);
}
