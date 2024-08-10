package Lesson36_exceptions.homework.task3;

public abstract class Event {
    String title;
    int releaseYear;
    int age;

    public Event(String title, int releaseYear, int age) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Название: " + title + ", год выпуска: " + releaseYear + ", рейтинг: " + age + "+.";
    }
}
