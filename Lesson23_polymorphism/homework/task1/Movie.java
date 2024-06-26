package Lesson23_polymorphism.homework.task1;

public class Movie implements MediaItem {
    private final int runTime;
    private final String title;

    public Movie(int runTime, String title) {
        this.runTime = runTime;
        this.title = title;
    }

    @Override
    public int getRunTime() {
        return runTime;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
