package Lesson30_linkedHashMap.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    int id;
    String title;
    String genre;
    List<String> actors = new ArrayList<>();
    String director;

    public Movie(int id, String title, String genre, String actor1, String actor2, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;

        actors.add(actor1);
        actors.add(actor2);
    }
}
