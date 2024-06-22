package Lesson22_abstract_interface.homework.task_1;

abstract public class Parallelogram implements Figure {
    double a;
    double b;
    public Parallelogram (double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        double area = a * b;
        return area;
    }
}
