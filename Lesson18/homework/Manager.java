package Lesson18.homework;

public class Manager extends Employee {
    String department;

    public Manager (String newName, double newSalary, String newDepartment) {
        super(newName, "Менеджер", newSalary);
        department = newDepartment;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Департамент: " + department);
    }
}
