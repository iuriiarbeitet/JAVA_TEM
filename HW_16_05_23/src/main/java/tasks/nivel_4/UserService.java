package tasks.nivel_4;

/**
 * Создайте класс UserService, который зависит от класса UserRepository. UserRepository содержит метод getUserByEmail(String email),
 *     возвращающий объект User по электронной почте. Напишите тест, используя Mockito, чтобы убедиться,
 *     что метод getUserByEmail был вызван с правильной электронной почтой и обработан правильно.
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
