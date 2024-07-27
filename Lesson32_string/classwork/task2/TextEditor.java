package Lesson32_string.classwork.task2;

public class TextEditor {
    private boolean isCapsLock = false;

    public void capsLock() {
        isCapsLock = !isCapsLock;
    }

    public void print(String str) {
        System.out.println(isCapsLock ? str.toUpperCase() : str);
    }
}
