package Lesson19.classwork.task1;

import java.util.ArrayList;

public class LostAndFoundOffice {
    ArrayList<Object> things = new ArrayList<>();


    void put (Object thing) {
       things.add(thing);
    }
    boolean check (Object thing) {
        if (thing != null) {
            return things.contains(thing);
        } else {
            return false;
        }
    }
}
