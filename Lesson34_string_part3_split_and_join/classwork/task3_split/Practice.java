package Lesson34_string_part3_split_and_join.classwork.task3_split;

public class Practice {
    public static void main(String[] args) {
        String dollarAssets = "Акции$Облигации$Фонды$";

        String[] split = dollarAssets.split("\\$"); // разбейте строку dollarAssets

        System.out.println(split[0].equals("Акции"));
        System.out.println(split[1].equals("Облигации"));
        System.out.println(split[2].equals("Фонды"));

    }
}
