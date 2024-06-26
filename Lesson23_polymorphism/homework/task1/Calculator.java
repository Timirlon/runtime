package Lesson23_polymorphism.homework.task1;

import java.util.List;

public class Calculator {
    public static double calculate (List <MediaItem> mediaItems) {
        double userRuntime = 0;
        for (MediaItem mediaItem : mediaItems) {
            userRuntime += mediaItem.getRunTime();
        }
        return userRuntime / 60 / 24;
    }
}
