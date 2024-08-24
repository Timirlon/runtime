package Lesson40_stream.homework.task2;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityExample {

    public static void main(String[] args) {
        //множество студентов, успешно сдавших экзамен
        Set<String> examPassedNames = new HashSet<>();
        examPassedNames.add("Иванов Иван");
        examPassedNames.add("Садыков Алибек");

        //соответствие года поступления и названия группы
        Map<Integer, String> groupNames = new HashMap<>();
        groupNames.put(2020, "2020-ГР1");
        groupNames.put(2021, "2021-ГР0");

        //список с адресами email выпускников
        List<String> graduatesClub = new ArrayList<>();

        //студенты, планирующие завершить обучение
        List<Student> students = new ArrayList<>();
        students.add(new Student("Садыков", "Алибек", "asadykov@gmail.com", 2021));
        students.add(new Student("Иванов", "Иван", "ivan_ivanov@gmail.com", 2020));
        students.add(new Student("Аманов", "Куаныш", "iamkuanysh@gmail.com", 2021));

        List<Student> graduatedStudents = students.stream()
                .filter(student -> examPassedNames.contains(student.surname + " " + student.name))
                .map(student -> {
                    student.groupName = groupNames.get(student.entranceYear);
                    return student;
                })
                .peek(student -> graduatesClub.add(student.email))
                .collect(Collectors.toList());

        for (Student student : graduatedStudents) {
            System.out.println(student);
        }

        for (String email : graduatesClub) {
            System.out.println(email);
        }

    }
}
