package Lesson12.task1;

public class Student {
    String name;
    int course;
    String faculty;
    Book book;

    void printInformation() {
        System.out.println("Имя студента: " + name);
        System.out.println("Курс обучения: " + course);
        System.out.println("Факультет: " + faculty);
        if(book.name != null) {
            System.out.println("Название книги: " + book.name);
        } else {
            System.out.println("Название книги: отсутсвует");
        }
        if(book.author != null) {
            System.out.println("Автор книги: " + book.author.name + " " + book.author.surname);
        } else {
            System.out.println("Автор книги: отсутствует");
        }
    }
}
