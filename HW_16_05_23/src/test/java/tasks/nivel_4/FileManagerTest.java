package tasks.nivel_4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class FileManagerTest {

    @Test
    public void testReadFile() {
        FileReader fileReader = Mockito.mock(FileReader.class);
        FileManager fileManager = new FileManager(fileReader);

        String filePath = "path/to/file.txt";
        String expectedContent = "File content";

        when(fileReader.readFile(eq(filePath))).thenReturn(expectedContent);

        String actualContent = fileManager.readFile(filePath);

        assertEquals(expectedContent, actualContent);
        Mockito.verify(fileReader, Mockito.times(1)).readFile(eq(filePath));
    }
}