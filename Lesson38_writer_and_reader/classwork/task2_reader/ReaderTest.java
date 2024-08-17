package Lesson38_writer_and_reader.classwork.task2_reader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Lesson38\\classwork\\task2\\result.txt"));
        Map<String, Integer> resultMap = new HashMap<>();


        while (bufferedReader.ready()) {
            String letter = bufferedReader.readLine();
            if (resultMap.containsKey(letter)) {
                resultMap.put(letter, resultMap.get(letter) + 1);
                continue;
            }
            resultMap.put(letter, 1);
        }

        for (Map.Entry<String, Integer> entrySet : resultMap.entrySet()) {
            System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
        }
    }
}
