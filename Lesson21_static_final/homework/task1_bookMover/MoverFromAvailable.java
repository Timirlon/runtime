package Lesson21_staticFinal.homework.task1_bookMover;

public class MoverFromAvailable extends BookMover {
    @Override
    protected void moveToStatus (Book requestedBook, Status requestedStatus) {
        if (requestedStatus == Status.BORROWED || requestedStatus == Status.ARCHIVED) {
            super.moveToStatus(requestedBook, requestedStatus);
        } else {
            System.out.println("Задан недействительный статус.");
        }
    }
}
