package com.eeswan.software.ch06.step0;

import java.awt.Point;
import java.util.Optional;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TwooterTest {


//    Twooter twooter = mock(Twooter.class);

    ReceiverEndPoint receiverEndPoint;

    private Twooter twooter;
    private SenderEndPoint endPoint;
    private final UserRepository userRepository = new InMemoryUserRepository();

    @Before
    public void setUp() {
        twooter = new Twooter(userRepository);
        twooter.onRegisterUser(TestData.USER_ID, TestData.PASSWORD);
    }

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        //유효 사용자의 로그인 메시지 수신
        //twooter.onLogon(TestData.USER_ID, receiverEndPoint);
        logon();
        // 로그온 메서드는 새 엔드포인트 반환

        // 엔드포인트 유효성을 확인하는 어서션
    }

    @Test
    public void shouldeNotAuthenticateUserWithWrongPassword() {
        final Optional<SenderEndPoint> endPoint = twooter.onLogon(
                TestData.USER_ID, "bad password", receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }

    @Test
    public void shouldNotAuthenticateUnKnownUser() {


    }

    private void logon() {
        this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
    }

    private SenderEndPoint logon(String userId, ReceiverEndPoint receiverEndPoint) {
        Optional<SenderEndPoint> endPoint = twooter.onLogon(userId, TestData.PASSWORD, receiverEndPoint);
        assertTrue("Failed to logon", endPoint.isPresent());
        return endPoint.get();
    }



}
