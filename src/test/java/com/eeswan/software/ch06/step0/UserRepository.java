package com.eeswan.software.ch06.step0;

import java.util.Optional;

public interface UserRepository {
    boolean add(User user);

    Optional<User> get(String userId);

    void update(User user);

    void clear();
}
