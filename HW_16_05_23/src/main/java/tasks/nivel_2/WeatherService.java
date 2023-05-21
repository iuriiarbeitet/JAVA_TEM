package tasks.nivel_2;

/**
 * Создайте класс WeatherService, который зависит от класса WeatherAPI.
 *     WeatherAPI содержит метод getTemperature(String city), возвращающий текущую температуру в указанном городе.
 *     Напишите тест, используя Mockito, чтобы проверить, что метод getTemperature был вызван с правильным городом и обработан правильно.
 */
public class WeatherService {
    private final WeatherAPI weatherAPI;

    public WeatherService(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public double getTemperature(String city) {
        return weatherAPI.getTemperature(city);
    }
}
