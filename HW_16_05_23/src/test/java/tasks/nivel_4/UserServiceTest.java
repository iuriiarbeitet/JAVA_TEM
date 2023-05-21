package tasks.nivel_4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Test
    public void testGetUserByEmail() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        String email = "test@example.com";
        User expectedUser = new User("Test User", email);

        when(userRepository.getUserByEmail(eq(email))).thenReturn(expectedUser);

        User actualUser = userService.getUserByEmail(email);

        assertEquals(expectedUser, actualUser);
        Mockito.verify(userRepository, Mockito.times(1)).getUserByEmail(eq(email));
    }
}
