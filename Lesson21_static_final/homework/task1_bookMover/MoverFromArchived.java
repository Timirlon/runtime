package Lesson21_staticFinal.homework.task1_bookMover;

public class MoverFromArchived extends BookMover {
    @Override
    protected void moveToStatus (Book requestedBook, Status requestedStatus) {
        if (requestedStatus == Status.AVAILABLE) {
            super.moveToStatus(requestedBook, requestedStatus);
        } else {
            System.out.println("Задан недействительный статус.");
        }
    }
}
