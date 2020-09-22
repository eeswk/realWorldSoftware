package com.eeswan.software.ch06.step0;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> userIdToUser = new HashMap<>();

    @Override
    public boolean add(User user) {
        return userIdToUser.putIfAbsent(user.getId(), user) == null;
    }

    @Override
    public Optional<User> get(String userId) {
        return Optional.ofNullable(userIdToUser.get(userId));
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void clear() {
        userIdToUser.clear();
    }
}
