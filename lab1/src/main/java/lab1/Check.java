package lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Check {

    public List<Object> checkTypes(String filePath) {
        List<Object> collectedData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                currentLine = currentLine.trim();

                if (currentLine.matches("^-?\\d+$")) {
                    collectedData.add(Integer.parseInt(currentLine));
                }
                else if (currentLine.matches("^-?\\d*\\.\\d+$")) {
                    collectedData.add(Double.parseDouble(currentLine));
                }
                else {
                    collectedData.add(currentLine);
                }
            }
        } catch (IOException error) {
            System.out.println("File reading error: " + error.getMessage());
        }
        return collectedData;
    }
}
