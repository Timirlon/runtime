package Lesson21_staticFinal.homework.task1_bookMover;

public class BookMover {
    protected void moveToStatus (Book requestedBook, Status requesteddStatus) {
        requestedBook.status = requesteddStatus;
        System.out.println("Статус изменен.");
    }
}
