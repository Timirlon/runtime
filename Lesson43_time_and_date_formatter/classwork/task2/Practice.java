package Lesson43_time_and_date_formatter.classwork.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Practice {
    public static void main(String[] args) {
        LocalDate secretDate = LocalDate.of(2020, 1, 10);
        LocalTime secretTime = LocalTime.of(12, 30);

        int result = decode(secretDate, secretTime);
        System.out.println(result);
    }

    private static int decode(LocalDate secretDate, LocalTime secretTime) {
        // объедините secretDate и secretTime
        LocalDateTime newTime = LocalDateTime.of(secretDate, secretTime);

        // вычтите 2 месяца, 25 дней и 100 минут
        LocalDateTime secretMoment = newTime.minusMinutes(100).minusDays(25).minusMonths(2);
        // найдите произведение порядкового номера дня в году и часов из secretMoment
        return secretMoment.getDayOfYear() * secretMoment.getHour();
    }
}