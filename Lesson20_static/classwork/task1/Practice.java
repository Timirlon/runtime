package Lesson20_static.classwork.task1;

import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<MountainHare> hares = List.of(
                new MountainHare(4, 4.4, 120),
                new MountainHare(7, 3.6, 150),
                new MountainHare(1, 2.3, 100)
        );

        System.out.println("В лесу лето!");
        Forest forest = new Forest("Лето", hares);
        // создайте объект "летний лес с зайцами"

        System.out.println("Список зайцев:");
        forest.printHares();

        System.out.println("В лесу зима!");
        forest.setSeason("Зима");
        // поменяйте время года на зиму

        System.out.println("Список зайцев:");
        forest.printHares();
    }

}
