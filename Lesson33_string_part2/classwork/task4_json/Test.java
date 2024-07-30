package Lesson33_string_part2.classwork.task4_json;

public class Test {
    public static void main(String[] args) {
        User user = new User("Игорь", 25);

        StringBuilder userJson = new StringBuilder();

        userJson.append("{\"name\": ");
        userJson.append("\"");
        userJson.append(user.name);
        userJson.append("\",");
        userJson.append(" \"age\": ");
        userJson.append(user.age);
        userJson.append("}");

        String asString = userJson.toString();
        System.out.println(asString);
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
