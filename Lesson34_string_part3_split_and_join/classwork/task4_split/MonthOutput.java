package Lesson34_string_part3_split_and_join.classwork.task4_split;

public class MonthOutput {
    public static void main(String[] args) {
        String months = "ЯНВАРЬ-ФЕВРАЛЬ-МАРТ-АПРЕЛЬ-МАЙ-ИЮНЬ-ИЮЛЬ-АВГУСТ-СЕНТЯБРЬ-ОКТЯБРЬ-НОЯБРЬ-ДЕКАБРЬ";

        String[] split = months.split("-");

        for (int i = 0; i < split.length; i++) {
            System.out.println(i + 1 + ". " + split[i].charAt(0) + split[i].substring(1).toLowerCase());
        }
    }
}
