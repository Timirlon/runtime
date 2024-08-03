package Lesson34_string_part3_split_and_join.homework.task2_join;

public class GradesReversed {

    private static String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    public static String serializeGrades(String[] grades) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < grades.length; i++) {
            String[] split = grades[i].split(" ");

            grades[i] = String.join(",", split[0].toLowerCase(), split[1].toLowerCase(), split[2], gradeStringToInt(split[4]));
        }

        return String.join(";", grades);
    }
}