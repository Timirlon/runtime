package Lesson33_string_part2.classwork.task1;

public class Main {
    public static void main(String[] args) {
        String rules = "На зелёный цвет — стой на месте;\n" +
                "на зелёный цвет — приготовься;\n" +
                "на зелёный — осмотрись, а затем смело шагай.";

        String replaced = rules.replace("цвет", "свет").replaceFirst("зелёный", "красный").replaceFirst("зелёный", "желтый");

        System.out.println(replaced);
    }

}
