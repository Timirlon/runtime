package Lesson24_generics.homework.task1;

public abstract class Contact {
    private final String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void sendMessage();

    abstract void print();
}
