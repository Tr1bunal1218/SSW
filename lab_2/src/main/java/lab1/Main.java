package lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int THREAD_COUNT = 2;
        int TOTAL_OBJECTS = 1000;
        String FILENAME = "test.txt";

        List<MultiThreadProcessor.RandomObjectWriter> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            System.out.print("Thread " + (i + 1) + ": [                                                  ] 0%\n");
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            MultiThreadProcessor.RandomObjectWriter thread = new MultiThreadProcessor.RandomObjectWriter(i + 1, TOTAL_OBJECTS / THREAD_COUNT, FILENAME);
            thread.start();
            threads.add(thread);
        }

        for (MultiThreadProcessor.RandomObjectWriter thread : threads) {
            try {
                thread.join();
                System.out.println("Thread #" + thread.getThreadNumber() + " (ID: " + thread.getId() + ") completed in " + thread.getExecutionTime() + " ms");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}