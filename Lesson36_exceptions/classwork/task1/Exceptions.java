package Lesson36_exceptions.classwork.task1;

import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        System.out.print("Введите целое число => ");
        Scanner scanner = new Scanner(System.in);
        final String inputValue = scanner.next();

        try {
            final int parsedValue = IntegerParser.parseInt(inputValue);
            System.out.println(parsedValue);
        } catch (EmptyStringException | NullPointerException firstException) {
            System.out.println("Введена пустая строка.");
        } catch (StringNotNumberException stringNotNumberException) {
            System.out.println("Вы ввели не целое число.");
        } catch (StringIsTooBigNumberException stringIsTooBigNumberException) {
            System.out.println("Введённое число слишком большое.");
        } catch (StringIsTooSmallNumberException stringIsTooSmallNumberException) {
            System.out.println("Введённое число слишком маленькое.");
        }

    }
}
