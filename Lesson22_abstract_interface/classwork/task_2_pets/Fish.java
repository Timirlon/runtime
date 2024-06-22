package Lesson22_abstract_interface.classwork.task_2_pets;

public class Fish extends Pet {
    public Fish () {
        super(0);
    }
    @Override
    public void giveVoice() {
        System.out.println("Буль-буль");
    }
}
