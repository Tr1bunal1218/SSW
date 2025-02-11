package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Check {

    // Метод для проверки всех типов данных из файла и их возврата в виде списка
    public List<Object> checkTypes(String filePath) {
        List<Object> collectedData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                currentLine = currentLine.trim();

                // Проверка на Integer (целые числа)
                if (currentLine.matches("^-?\\d+$")) {
                    collectedData.add(Integer.parseInt(currentLine));
                }
                // Проверка на Double (вещественные числа)
                else if (currentLine.matches("^-?\\d*\\.\\d+$")) {
                    collectedData.add(Double.parseDouble(currentLine));
                }
                // Строки: если не попали под вышеописанные условия
                else {
                    collectedData.add(currentLine);
                }
            }
        } catch (IOException error) {
            System.out.println("Ошибка чтения файла: " + error.getMessage());
        }
        return collectedData; // Возвращаем все собранные данные
    }
}
