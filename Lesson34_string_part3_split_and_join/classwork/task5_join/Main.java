package Lesson34_string_part3_split_and_join.classwork.task5_join;

public class Main {
    public static void main(String[] args) {
        String[] rainbow = new String[]{
                "Красный",
                "Оранжевый",
                "Жёлтый",
                "Зелёный",
                "Голубой",
                "Синий",
                "Фиолетовый"
        };

        String join = String.join(", ", rainbow);

        System.out.println(join);
    }
}
