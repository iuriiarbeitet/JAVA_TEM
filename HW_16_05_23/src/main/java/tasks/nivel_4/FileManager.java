package tasks.nivel_4;

/**
 * Создайте класс FileManager, который зависит от класса FileReader. FileReader содержит метод readFile(String filePath),
 *     возвращающий содержимое файла. Напишите тест, используя Mockito, чтобы проверить,
 *     что метод readFile был вызван с правильным путем к файлу и обработан корректно.
 */
public class FileManager {
    private FileReader fileReader;

    public FileManager(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String readFile(String filePath) {
        return fileReader.readFile(filePath);
    }
}
