package Lesson19.classwork.task2;

import java.util.Objects;

public class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Song song = (Song) object;
        return Objects.equals(title, song.title)
                && Objects.equals(artist, song.artist)
                && Objects.equals(songwriter, song.songwriter);
    }
}
