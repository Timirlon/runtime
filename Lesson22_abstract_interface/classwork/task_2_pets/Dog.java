package Lesson22_abstract_interface.classwork.task_2_pets;

public class Dog extends Pet {
    public Dog () {
        super(4);
    }
    @Override
    public void giveVoice() {
        System.out.println("Гав");
    }

    public void bringStick () {
        System.out.println("Принес палочку, как хороший мальчик!");
    }
}
