package Lesson33_string_part2.classwork.task3_string_builder;

public class Practice {
    public static void main(String[] args) {
        String start = "Привет! Меня зовут ";

        StringBuilder hello = new StringBuilder(start);  // создайте StringBuilder с началом start

        hello.append("Темирлан. ");   // добавьте подстроку "<ваше имя>"
        hello.append("Я из города ");   // добавьте подстроку ". Я из города "
        hello.append("Астана.");   // добавьте подстроку "<ваш город>."

        String asString = hello.toString();
        System.out.println(asString);
    }
}
