package Lesson19.classwork.task3;

public class Item {
    Song song;


    @Override
    public String toString () {
        return "\"song\": " + song.title + " \"artist\": " + song.artist + "songwriter: " + song.songwriter;
    }
}
