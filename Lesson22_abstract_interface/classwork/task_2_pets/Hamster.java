package Lesson22_abstract_interface.classwork.task_2_pets;

public class Hamster extends Pet {
    public Hamster () {
        super(4);
    }

    @Override
    public void giveVoice() {
        System.out.println("Писк");
    }

    public void hideFood() {
        System.out.println("Вся еда - в щечках.");
    }
}
