package Lesson18.homework;
public class Employee {
    String name;
    String position;
    double salary;

    public Employee (String newName, String newPosition, double newSalary) {
        name = newName;
        position = newPosition;
        salary = newSalary;
    }

    void displayInfo () {
        System.out.println("Имя сотрудника: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Зарплата: " + salary + " тг.");
    }
}
