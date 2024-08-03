package Lesson34_string_part3_split_and_join.homework.task1_split;

public class Grades {

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private static String gradeToString(String grade) {
        switch (grade) {
            case "5": {
                return "Безупречно";
            }
            case "4": {
                return "Потрясающе";
            }
            case "3": {
                return "Восхитительно";
            }
            case "2": {
                return "Прекрасно";
            }
            default:
                return "Очаровательно";
        }
    }

    // grades - строка вида "имя,фамилия,предмет,оценка;имя,фамилия,предмет,оценка;"
    public static void gradeBeautifier(String grades) {
        String[] split = grades.split(";");

        for (String word : split) {
            String[] splitAgain = word.split(",");

            StringBuilder stringBuilder = new StringBuilder(capitalize(splitAgain[0]));
            stringBuilder.append(" ");
            stringBuilder.append(capitalize(splitAgain[1]));
            stringBuilder.append(" ");
            stringBuilder.append(splitAgain[2].toLowerCase());
            stringBuilder.append(" — ");
            stringBuilder.append(gradeToString(splitAgain[3]));

            System.out.println(stringBuilder);
        }
    }

    public static void main(String[] args) {
        String test = "вероника,чехова,ФИЗИКА,5;анна,строкова,МАТЕМАТИКА,4;иван,петров,ГЕОМЕТРИЯ,5";
        gradeBeautifier(test);
    }
}

