package lab1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "src/files/input.txt";
            Check verifier = new Check();
            List<Object> collectedData = verifier.checkTypes(filePath);  // Получаем все данные

            Split<Integer> integerDistributor = new Split<>(Integer.class, true);  // Очистка файла перед записью
            Split<Double> doubleDistributor = new Split<>(Double.class, true); // Очистка файла перед записью
            Split<String> stringDistributor = new Split<>(String.class, true);  // Очистка файла перед записью

            for (Object item : collectedData) {
                if (item instanceof Integer) {
                    integerDistributor.makeSplit((Integer) item);
                } else if (item instanceof Double) {
                    doubleDistributor.makeSplit((Double) item);
                } else if (item instanceof String) {
                    stringDistributor.makeSplit((String) item);
                }
            }
            System.out.println("The data has been successfully splited into files!");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
