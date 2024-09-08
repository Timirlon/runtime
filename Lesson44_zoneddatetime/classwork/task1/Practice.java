package Lesson44_zoneddatetime.classwork.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Practice {
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;

    public static void main(String[] args) {
        LocalDateTime firstStart = LocalDateTime.of(2099, 10, 10, 12, 5);
        LocalDateTime firstFinish = LocalDateTime.of(2099, 10, 10, 14, 15);

        LocalDateTime secondStart = LocalDateTime.of(2099, 10, 10, 12, 0);
        LocalDateTime secondFinish = LocalDateTime.of(2099, 10, 11, 15, 30);

        LocalDateTime thirdStart = LocalDateTime.of(2099, 10, 10, 23, 10);
        LocalDateTime thirdFinish = LocalDateTime.of(2099, 10, 11, 10, 25);


        printGap(firstStart, firstFinish);
        printGap(secondStart, secondFinish);
        printGap(thirdStart, thirdFinish);
    }

    private static void printGap(LocalDateTime start, LocalDateTime finish) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");

        System.out.println("Вход в гиперпространство:");
        System.out.println(start.format(formatter));
        System.out.println("Выход из гиперпространства:");
        System.out.println(finish.format(formatter));
        Duration duration = Duration.between(start, finish);

        if (duration.getSeconds() > SECONDS_IN_DAY) {
            System.out.println("Дней на гиперпрыжок: " + (duration.getSeconds() / SECONDS_IN_DAY));
        } else {
            System.out.println("Минут на гиперпрыжок: " + (duration.getSeconds() / 60));
        }
        System.out.println();
    }
}
