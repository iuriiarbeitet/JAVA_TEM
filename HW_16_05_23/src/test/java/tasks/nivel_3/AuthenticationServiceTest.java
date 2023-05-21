package tasks.nivel_3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class AuthenticationServiceTest {

    @Test
    public void testGetUserById() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        String userId = "123";
        authenticationService.getUserById(userId);
        verify(userRepository).getUserById(userId);
    }
}