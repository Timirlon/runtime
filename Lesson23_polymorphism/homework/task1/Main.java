package Lesson23_polymorphism.homework.task1;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<MediaItem> mediaItems = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.print("Введите название фильма: ");
                String title = scanner.next();
                System.out.print("Введите длительность фильма в минутах: ");
                int runtime = scanner.nextInt();

                Movie movie = new Movie(runtime, title);
                mediaItems.add(movie);
            } else if (command == 2) {
                System.out.print("Введите название сериала: ");
                String title = scanner.next();
                System.out.print("Введите количество серий: ");
                int seriesCount = scanner.nextInt();
                System.out.print("Введите среднюю длительность серии в минутах: ");
                int runtime = scanner.nextInt();

                Series series = new Series(runtime, title, seriesCount);
                mediaItems.add(series);
            } else if (command == 0) {
                printMediaItemsList(mediaItems);

                double totalRuntime = Calculator.calculate(mediaItems);
                System.out.println("Всего вы потратили на просмотр фильмов и сериалов, в днях: " + totalRuntime);
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Добавить фильм");
        System.out.println("2 - Добавить сериал");
        System.out.println("0 - Посчитать суммарное время и выйти");
    }


    public static void printMediaItemsList(List<MediaItem> mediaItems) {
        System.out.println("Вы посмотрели " + mediaItems.size() + " фильмов и сериалов: ");

        for (MediaItem mediaItem : mediaItems) {
            System.out.println("- " + mediaItem.getTitle());
        }
    }
}
