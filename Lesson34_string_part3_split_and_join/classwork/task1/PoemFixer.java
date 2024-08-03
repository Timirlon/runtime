package Lesson34_string_part3_split_and_join.classwork.task1;

public class PoemFixer {

    public String[] readPoem() {
        return new String[]{
                "   Это кто там ложку «ложит»?",
                "",
                "   ",
                "Знай, такого быть не может!",
                "  Ложку мы на стол кладём,  ",
                "",
                "А тебя – к обеду ждём."
        };
    }

    public String fixPoem(String[] poem) {
        StringBuilder poemBuilder = new StringBuilder();
        for (String poemLine : poem) {
            if (poemLine.isBlank()) {
                continue;
            }

            poemBuilder.append(poemLine.trim());
            poemBuilder.append("\n");
        }

        return poemBuilder.toString();
    }

    public static void main(String[] args) {
        PoemFixer poemFixer = new PoemFixer();
        String[] poem = poemFixer.readPoem();
        String poemAsString = poemFixer.fixPoem(poem);
        System.out.println(poemAsString);
    }
}
