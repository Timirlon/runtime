package Lesson42_timestamp.classwork.task3_local_date;

import java.time.LocalDateTime;
import static java.time.Month.JUNE;

public class Practice {

    public static final int START_YEAR = 2025;
    public static final int START_DAY = 1;
    public static final int MAX_SHIFT = 8;

    public static void main(String[] args) {
        printWorkHours(8, 30, 5, 5);
    }

    private static void printWorkHours(int startHours, int startMinutes, int shiftContinuation, int shiftAmount) {
        if (shiftContinuation > MAX_SHIFT){
            System.out.println("Выбрано слишком большое время для рабочей смены!");
            return;
        }
        System.out.println("Расписание смен:");
        LocalDateTime startTime = LocalDateTime.of(START_YEAR, JUNE, START_DAY, startHours, startMinutes);
        LocalDateTime endTime;
        for (int i = 1; i <= shiftAmount; i++){
            endTime = startTime.plusHours(shiftContinuation);
            System.out.println("Cмена " + i + ". Начало: " + startTime + ", конец: " + endTime);
            startTime = endTime;
        }
    }
}
