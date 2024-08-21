package Lesson39_lambda_function.classwork.task1_try_with_resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));) {
            fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
