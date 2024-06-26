package Lesson23_polymorphism.homework.task1;

public class Series implements MediaItem{
    private final int averageRunTime;
    private final String title;
    private final int seriesCount;

    public Series(int runTime, String title, int seriesCount) {
        averageRunTime = runTime;
        this.title = title;
        this.seriesCount = seriesCount;
    }

    @Override
    public int getRunTime() {
        return averageRunTime * seriesCount;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getSeriesCount() {
        return seriesCount;
    }
}
