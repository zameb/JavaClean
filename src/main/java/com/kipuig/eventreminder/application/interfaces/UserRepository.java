package com.kipuig.eventreminder.application.interfaces;

import com.kipuig.eventreminder.domain.entities.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> getUserById(UUID id);

    public void save(User user);
}
