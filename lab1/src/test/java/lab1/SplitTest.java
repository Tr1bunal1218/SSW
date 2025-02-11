package lab1;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class SplitTest {

    private static final String INT_FILE = "src/files/integer.txt";
    private static final String DOUBLE_FILE = "src/files/float.txt";
    private static final String STRING_FILE = "src/files/string.txt";

    @BeforeEach
    public void setUp() {
        // Очистка файлов перед каждым тестом
        clearFile(INT_FILE);
        clearFile(DOUBLE_FILE);
        clearFile(STRING_FILE);
    }

    @Test
    public void testIntegerDistribution() {
        Split<Integer> split = new Split<>(Integer.class);
        split.makeSplit(123);

        // Проверяем, что файл не пуст
        assertTrue(isFileNotEmpty(INT_FILE));
    }

    @Test
    public void testDoubleDistribution() {
        Split<Double> split = new Split<>(Double.class);
        split.makeSplit(123.456);

        assertTrue(isFileNotEmpty(DOUBLE_FILE));
    }

    @Test
    public void testStringDistribution() {
        Split<String> split = new Split<>(String.class);
        split.makeSplit("TestString");

        assertTrue(isFileNotEmpty(STRING_FILE));
    }

    @Test
    public void testFileClearingBeforeWriting() {
        // Создаем экземпляр класса Distribution и сбрасываем флаг очистки перед каждым использованием
        Split<Integer> split = new Split<>(Integer.class, true);

        // Очистка файла перед первой записью


        // Запишем что-то в файл
        split.makeSplit(123);
        split.resetWriteFlag();
        // Запишем что-то новое, файл должен быть очищен перед этим
        split.makeSplit(456);

        // Проверим, что файл содержит только одно значение
        try {
            String content = new String(Files.readAllBytes(Paths.get(INT_FILE)));
            assertEquals("456\n", content);
        } catch (IOException e) {
            fail("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private void clearFile(String fileName) {
        try {
            Files.write(Paths.get(fileName), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isFileNotEmpty(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.length() > 0;
    }
}
