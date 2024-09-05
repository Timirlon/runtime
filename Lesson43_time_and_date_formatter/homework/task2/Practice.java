package Lesson43_time_and_date_formatter.homework.task2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Practice {
    public static void main(String[] args) {
        LocalTime taskStart = LocalTime.of(9, 0);
        LocalTime taskFinish = LocalTime.of(11, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Duration duration = Duration.between(taskStart, taskFinish);

        System.out.println("В прошлый раз задача была начата в " + taskStart.format(formatter) + ",");
        System.out.println("а закончена в " + taskFinish.format(formatter) + ".");

        LocalTime now = LocalTime.now();
        System.out.println("Сейчас " + now.format(formatter) + ".");

        LocalTime finishTime = now.plus(duration);

        System.out.println("Значит, задача будет выполнена к " + finishTime.format(formatter) + ".");
    }
}
