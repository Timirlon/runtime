package Lesson22_abstract_interface.classwork.task_2_pets;

public abstract class Pet {
    int pawsCount;

    public Pet (int pawsCount) {
        this.pawsCount = pawsCount;
    }

    public void sleep () {
        System.out.println("Сплю");
    }

    public void play () {
        System.out.println("Играю");
    }

    abstract public void giveVoice ();

    int getPawsCount() {
        return pawsCount;
    }
}
