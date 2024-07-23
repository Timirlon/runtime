package Lesson30_linkedHashMap.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Integer> watchedMovies = new ArrayList<>();

    public User(int id, String name, int movie1, int movie2) {
        this.id = id;
        this.name = name;

        watchedMovies.add(movie1);
        watchedMovies.add(movie2);
    }
}
