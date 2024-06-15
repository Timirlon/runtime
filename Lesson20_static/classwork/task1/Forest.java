package Lesson20_static.classwork.task1;

import java.util.List;

public class Forest {
    private List<MountainHare> hares;
    static String season;

    public Forest (String newSeason, List<MountainHare> hareList) {
        season = newSeason;
        hares = hareList;
    }

    void setSeason (String newSeason) {
        season = newSeason;

        if (season.equals("Лето")) {
            for (MountainHare hare: hares) {
                hare.color = "Серо рыжий";
            }
        } else if (season.equals("Зима")) {
            for (MountainHare hare : hares) {
                hare.color = "Белый";
            }
        }
    }

    void printHares () {
        for (MountainHare hare : hares) {
            hare.toString();
        }
    }
}
