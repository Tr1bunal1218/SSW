package lab1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckTest {

    @Test
    public void testCheckTypesFromFileInteger() {
        String filename = "src/files/test_integers.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("123\n");
            writer.write("-456\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Check check = new Check();
        List<Object> dataList = check.checkTypes(filename);

        assertEquals(2, dataList.size());
        assertTrue(dataList.get(0) instanceof Integer);
        assertTrue(dataList.get(1) instanceof Integer);
        assertEquals(123, dataList.get(0));
        assertEquals(-456, dataList.get(1));
    }

    @Test
    public void testCheckTypesFromFileDouble() {
        String filename = "src/files/test_doubles.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("123.45\n");
            writer.write("-678.90\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Check check = new Check();
        List<Object> dataList = check.checkTypes(filename);

        assertEquals(2, dataList.size());
        assertTrue(dataList.get(0) instanceof Double);
        assertTrue(dataList.get(1) instanceof Double);
        assertEquals(123.45, dataList.get(0));
        assertEquals(-678.90, dataList.get(1));
    }

    @Test
    public void testCheckTypesFromFileString() {
        String filename = "src/files/test_strings.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Hello\n");
            writer.write("World\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Check check = new Check();
        List<Object> dataList = check.checkTypes(filename);

        assertEquals(2, dataList.size());
        assertTrue(dataList.get(0) instanceof String);
        assertTrue(dataList.get(1) instanceof String);
        assertEquals("Hello", dataList.get(0));
        assertEquals("World", dataList.get(1));
    }
}
