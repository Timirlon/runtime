package Lesson44_zoneddatetime.homework.task2;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Practice {
    public static void main(String[] args) {
        Instant now = Instant.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy; HH:mm:ss. ZZZZZ");

        ZoneId qyzylordaZone = ZoneId.of("Asia/Qyzylorda");
        ZonedDateTime qyzylordaDateTime = ZonedDateTime.ofInstant(now, qyzylordaZone);

        printTime(formatter, qyzylordaDateTime, "Қызылорда");

        convertAndPrintTime(formatter, qyzylordaDateTime, "Осло", "Europe/Oslo");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Чикаго", "America/Chicago");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Шанхай", "Asia/Shanghai");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Аддис-Абеба", "Africa/Addis_Ababa");
    }

    private static void convertAndPrintTime(DateTimeFormatter formatter, ZonedDateTime qyzylordaDateTime, String cityName, String region) {
        ZoneId newZone = ZoneId.of(region);
        ZonedDateTime newDateTime = qyzylordaDateTime.withZoneSameInstant(newZone);

        printTime(formatter, newDateTime, cityName);
    }

    private static void printTime(DateTimeFormatter formatter, ZonedDateTime dateTime, String cityName) {
        System.out.println(cityName + ":");

        System.out.println(dateTime.format(formatter));
    }
}
