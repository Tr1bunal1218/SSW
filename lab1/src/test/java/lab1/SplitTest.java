package lab1;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class SplitTest {

    private static final String INT_FILE = "src/files/integers.txt";
    private static final String DOUBLE_FILE = "src/files/doubles.txt";
    private static final String STRING_FILE = "src/files/strings.txt";

    @BeforeEach
    public void setUp() {
        clearFile(INT_FILE);
        clearFile(DOUBLE_FILE);
        clearFile(STRING_FILE);
    }

    @Test
    public void testIntegerDistribution() {
        Split<Integer> split = new Split<>(Integer.class);
        split.makeSplit(123);

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
        Split<Integer> split = new Split<>(Integer.class, true);

        split.makeSplit(123);
        split.resetWriteFlag();
        split.makeSplit(456);

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
