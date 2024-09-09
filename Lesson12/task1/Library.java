package Lesson12.task1;

public class Library {
    Book[] books;

    void addBook(Book newBook) {
        for(int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = newBook;
                return;
            }
        }
        System.out.println("Недостаточно места в библиотеке!");
    }

    void deleteBook(Book newBook) {
        for(int i = 0; i < books.length; i++) {
            if(books[i] == newBook) {
                books[i] = null;
                return;
            }
        }
        System.out.println("Данная книга не найдена в библиотеке.");
    }
    void lendBook(Student student, String bookName) {
        for (int i = 0; i < books.length; i++) {
            if (student.book == null && books[i].name == bookName) {
                student.book = books[i];
                books[i] = null;
                System.out.println("Вам передана книга под названием \"" + bookName + "\".");
                return;
            } else if (student.book != null && books[i] != null) {
                System.out.println("У вас уже есть книга!");
                return;
            }
        }
        System.out.println("В библиотеке отсутствует книга с названием " + bookName);
    }

    void acceptBook(Student student) {
        for (int i = 0; i < books.length; i++) {
            if (student.book != null && books[i] == null) {
                books[i] = student.book;
                student.book = null;
                System.out.println("Ваша книга под названием \"" + books[i].name + "\" была передана в библиотеку");
                return;
            } else if (student.book == null) {
                System.out.println("У вас отсутсвует книга для сдачи в библиотеку.");
                return;
            }
        }
        System.out.println("В библиотеке нет места для вашей книги.");
    }
}
