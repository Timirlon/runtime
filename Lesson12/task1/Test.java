package Lesson12.task1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Author marx = new Author();
        marx.name = "Карл";
        marx.surname = "Маркс";

        Book capital = new Book();
        capital.name = "Капитал";
        capital.author = marx;
        capital.pageNumber = 1000;

        Student student = new Student();
        student.name = "Ярик";
        student.course = 2;
        student.faculty = "Юриспруденция";
        student.book = capital;

        Library library = new Library();
        library.books = new Book[5];
        library.acceptBook(student);

        String capitalName = "Капитал";

        System.out.println(Arrays.toString(library.books));

        library.lendBook(student, capitalName);

        System.out.println(Arrays.toString(library.books));
    }
}
