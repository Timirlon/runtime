package Lesson11.Homework;

public class Car {
    String brand;
    String model;
    int year;
    double fuelLevel;
    double fuelConsumption;

    public void refuel(double liters) {
        fuelLevel += liters;
        System.out.println("Заправлено " + liters +
                " литров. Текущий уровень топлива: " + fuelLevel + " л.");
    }
    public void drive(double distance) {
        if(fuelLevel >= distance * (fuelConsumption / 100)) {
            fuelLevel -= distance * (fuelConsumption / 100);
            System.out.println("Пройдено " + distance + " км. Осталось топлива: " +
                    fuelLevel + " л.");
        }
        else {
            System.out.println("Недостаточно топлива для данного расстояния.");
        }
    }
}
