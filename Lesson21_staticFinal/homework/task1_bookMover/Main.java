package Lesson21_staticFinal.homework.task1_bookMover;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Lord of the Rings");
        BookMover moverFromAvailable = new MoverFromAvailable();
        moverFromAvailable.moveToStatus(book, Status.BORROWED);
        System.out.println(book.status);
    }
}
