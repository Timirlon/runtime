package Lesson34_string_part3_split_and_join.classwork.task2;

public class Palindrome {
    public static boolean isPalindromeWord(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }

    public static boolean isPalindromeLine(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String currentSymbol = str.substring(i, i + 1);
            if(!currentSymbol.isBlank()) {
                stringBuilder.append(currentSymbol);
            }
        }

        return stringBuilder.toString().equalsIgnoreCase(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeWord("комок"));
        System.out.println(isPalindromeWord("человек"));

        System.out.println(isPalindromeLine("Молебен о коне белом"));
        System.out.println(isPalindromeLine("Я хочу кушать"));
    }
}
