package Lesson20_static.classwork.task1;

public class MountainHare {
    int age;
    double weight;
    double jumpLength;
    String color;

    public MountainHare (int newAge, double newWeight, double newJumpLength) {
        age = newAge;
        weight = newWeight;
        jumpLength = newJumpLength;
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
                "age=" + age +
                ", weight=" + weight +
                ", jumpLength=" + jumpLength +
                ", color=" + color +
                '.';
    }
}
