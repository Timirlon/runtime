package Lesson21_staticFinal.homework.task1_bookMover;

public class MoverFromOverdued extends BookMover {
    @Override
    protected void moveToStatus (Book requestedBook, Status requestedStatus) {
        if (requestedStatus == Status.AVAILABLE || requestedStatus == Status.ARCHIVED) {
            super.moveToStatus(requestedBook, requestedStatus);
        } else {
            System.out.println("Задан недействительный статус.");
        }
    }
}
