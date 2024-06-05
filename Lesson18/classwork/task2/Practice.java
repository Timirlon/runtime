package Lesson18.classwork.task2;

class Actor {
    void play() {
        System.out.println("Гул затих. Я вышел на подмостки.");
    }
}

class Hamlet extends Actor {
    @Override
    void play() {
        System.out.println("Быть или не быть? Вот в чём вопрос?");
    }
}

public class Practice {
    public static void main(String[] args) {
        Hamlet performer = new Hamlet();
        performer.play();
    }
}

