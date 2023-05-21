package tasks.nivel_2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class UserServiceTest {


@Test
public void saveUser_callsUserRepositorySaveUser_withCorrectUser() {
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    UserService userService = new UserService(userRepository);
    User user = new User("John");
    userService.makeSaveUser(user);
    verify(userRepository).saveUser(user);

}
}
