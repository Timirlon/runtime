package Lesson18.homework;

public class Developer extends Employee {
    String mainProgrammingLanguage;

    public Developer (String newName, double newSalary, String newProgrammingLanguage) {
        super(newName, "Разработчик", newSalary);
        mainProgrammingLanguage = newProgrammingLanguage;
    }

    @Override
    void displayInfo () {
        super.displayInfo();
        System.out.println("Основной язык программирования: " + mainProgrammingLanguage);
    }
}
