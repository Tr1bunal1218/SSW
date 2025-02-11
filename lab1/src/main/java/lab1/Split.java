package lab1;

import java.io.*;

public class Split<Type> {
    private Class<Type> dataType;
    private boolean firstWrite = true;
    private boolean clearBeforeWrite;

    public Split(Class<Type> type) {
        this.dataType = type;
        clearBeforeWrite = false;
    }

    public Split(Class<Type> type, boolean clearBeforeWrite) {
        this.dataType = type;
        this.clearBeforeWrite = clearBeforeWrite;
    }

    public void makeSplit(Type value) {
        String outputFile = "";

        if (dataType == Integer.class) {
            outputFile = "src/files/integers.txt";
        } else if (dataType == Double.class) {
            outputFile = "src/files/floats.txt";
        } else if (dataType == String.class) {
            outputFile = "src/files/strings.txt";
        }

        if (firstWrite && clearBeforeWrite) {
            wipeFile(outputFile);
            firstWrite = false;
        }

        try (FileWriter fileWriter = new FileWriter(outputFile, true)) {
            fileWriter.write(value.toString() + "\n");
        } catch (IOException error) {
            System.out.println("Ошибка записи в файл: " + error.getMessage());
        }
    }

    private void wipeFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write("");
        } catch (IOException error) {
            System.out.println("Ошибка очистки файла: " + filePath);
        }
    }

    public void resetWriteFlag() {
        firstWrite = true;
    }
}