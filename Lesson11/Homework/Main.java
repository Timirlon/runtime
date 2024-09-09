package Lesson11.Homework;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "Lamborghini";
        myCar.model = "Aventador";
        myCar.year = 2011;
        myCar.fuelConsumption = 7.5;

        myCar.refuel(50);
        myCar.drive(400);
        myCar.drive(500);
    }
}
