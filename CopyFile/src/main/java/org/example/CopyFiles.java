package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


/**
 *  Считать с консоли имя файла. Создать копию файла в той же директории,
 *  где лежит исходный файл. Имя копии должно быть тем же, что у исходного файла с префиксом copied_.
 */
public class CopyFiles {

      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя исходного файла: ");
            String fileName = scanner.nextLine();

            Path sourcePath = Path.of(fileName);
            Path targetPath = sourcePath.resolveSibling("copied_" + sourcePath.getFileName());

            try {
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Копия файла успешно создана: " + targetPath);
            } catch (IOException e) {
                System.err.println("Ошибка при создании копии файла: " + e.getMessage());
            }
        }

}