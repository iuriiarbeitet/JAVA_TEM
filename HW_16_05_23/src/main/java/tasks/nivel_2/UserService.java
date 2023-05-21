package tasks.nivel_2;

/**
 * Создайте класс UserService, который зависит от класса UserRepository.
 *     UserRepository содержит метод saveUser(User user), сохраняющий пользователя в базе данных.
 *     Напишите тест, используя Mockito, чтобы убедиться, что метод saveUser был вызван с корректным пользователем.
 */
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void makeSaveUser(User user) {
        userRepository.saveUser(user);
    }
}
