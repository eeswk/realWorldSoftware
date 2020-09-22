package com.eeswan.software.ch06.step0;

import java.util.Optional;

public class Twooter {
    private final UserRepository userRepository;

    public Twooter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Object> onLogon(String userId, ReceiverEndPoint receiverEndPoint) {
        return Optional.empty();
    }

    public Optional<SenderEndPoint> onLogon(String userId, String password, ReceiverEndPoint receiverEndPoint) {
        Optional<User> authenticatedUser = userRepository.get(userId)
                .filter(userOfSameId -> {
                    return password.equals(userOfSameId.getPassword());
                });

        authenticatedUser.ifPresent(System.out::println);

        return authenticatedUser.map(user -> new SenderEndPoint(user, this));
    }

    public void onRegisterUser(final String userId, final String password) {
        User user = new User(userId, password);
        userRepository.add(user);
    }
}

