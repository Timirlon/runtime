package Lesson21_staticFinal.classwork.task1;

import java.util.ArrayList;
import java.util.List;

public class Song {
    final String artist;
    final String title;
    final String genre;

    public Song (String artist, String title, String genre) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
    }

    public static void main(String[] args) {
        List<Song> goldenHitsCollection = new ArrayList<>();

        goldenHitsCollection.add(new Song("Исполнитель","Название","Жанр")); // добавление нового хита
    }
}
