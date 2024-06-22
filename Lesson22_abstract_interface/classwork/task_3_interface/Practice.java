package Lesson22_abstract_interface.classwork.task_3_interface;

import java.util.ArrayList;
import java.util.List;

interface NoteBook {
    void addNote(String note);

    void deleteNote(int index);
}

class CalendarApp implements NoteBook {
    List<String> notes = new ArrayList<>();

    @Override
    public void addNote(String note) {
        notes.add(note);
        System.out.println("Заметка успешно добавлена!");
    }

    @Override
    public void deleteNote(int index) {
        if (index >= notes.size() || index < 0) {
            System.out.println("Неверный индекс для удаления заметки.");
        } else {
            notes.remove(index);
            System.out.println("Заметка успешно удалена!");
        }
    }
}

public class Practice {
    public static void main(String[] args) {
        CalendarApp noteBook = new CalendarApp();
        noteBook.addNote("Зайти в магазин после работы.");
        noteBook.addNote("Позвонить маме.");

        noteBook.deleteNote(2);
    }
}