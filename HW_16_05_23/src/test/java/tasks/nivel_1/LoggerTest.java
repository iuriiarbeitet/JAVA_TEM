package tasks.nivel_1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

     @Test
    public void testLog() {
        Logger logger = Mockito.mock(Logger.class); // создаем мок объект класса Logger
        logger.log("Test message"); // вызываем метод log
        Mockito.verify(logger).log(Mockito.anyString()); // проверяем, что метод log был вызван хотя бы один раз
    }
}

