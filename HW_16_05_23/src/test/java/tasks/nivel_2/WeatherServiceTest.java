package tasks.nivel_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WeatherServiceTest {

    @Test
    void getTemperature() {
    }
    @Test
    void testGetTemperature() {
        // Создаем mock объект WeatherAPI
        WeatherAPI weatherAPIMock = Mockito.mock(WeatherAPI.class);

        // Создаем экземпляр класса WeatherService, передавая ему mock объект WeatherAPI
        WeatherService weatherService = new WeatherService(weatherAPIMock);

        // Устанавливаем ожидаемый результат
        String city = "London";
        double temperature = 22.5;
        Mockito.when(weatherAPIMock.getTemperature(city)).thenReturn(temperature);

        // Вызываем метод getTemperature
        double result = weatherService.getTemperature(city);

        // Проверяем, что метод getTemperature был вызван с правильным городом
        Mockito.verify(weatherAPIMock).getTemperature(city);

        // Проверяем, что результат соответствует ожидаемой температуре
        Assertions.assertEquals(temperature, result);
    }
}