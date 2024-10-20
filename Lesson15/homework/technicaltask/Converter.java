package Lesson15.homework.technicaltask;

public class Converter {
    int convertToKm (int steps) {
        int convertedToKm = steps / (100000 / 75);
        return convertedToKm;
    }

    int convertStepsToKilocalories (int steps) {
        int convertedToKcal = steps / (1000 / 50);
        return convertedToKcal;
    }
}
