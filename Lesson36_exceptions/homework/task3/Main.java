package Lesson36_exceptions.homework.task3;

public class Main {
    public static void main(String[] args) {
        for (Event movie : getMovies()) {
            validEvent(movie);
        }

        for (Event theatre: getTheatres()) {
            validEvent(theatre);
        }

        System.out.println("Все события корректны.");
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало", 2010, 16),
                new Movie("Побег из Шоушенка", 1994, 18),
                new Movie("Зеленый слоник", 1999, 18)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Гамлет", 2022, 14),
                new Theatre("Ревизор", 2020, 12)
        };
    }

    public static void validEvent(Event event) throws RuntimeException {
        if (event.title == null || event.releaseYear == 0 || event.age == 0) {
            throw new RuntimeException();
        }
    }
}
