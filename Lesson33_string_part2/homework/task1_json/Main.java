package Lesson33_string_part2.homework.task1_json;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        User[] users = new User[10];

        for (int i = 0; i < users.length; i++) {
            String userName = "User #" + (i + 1);
            int userAge = 20 + i;
            Post[] posts = new Post[random.nextInt(1, 6)];
            for (int j = 0; j < posts.length; j++) {
                String postTitle = userName + " Post #" + (j + 1);
                String description = userName + " some description #" + (j + 1);
                int likesCount = random.nextInt(0, 1_000_000);
                posts[j] = new Post(postTitle, description, likesCount);
            }
            users[i] = new User(userName, userAge, posts);
        }

        StringBuilder stringBuilder = new StringBuilder("[ ");

        int count1 = 1;
        for (User user : users) {
            stringBuilder.append("\n\t{");

            stringBuilder.append("\n\t\t\"name\": \"");
            stringBuilder.append(user.name);
            stringBuilder.append("\", ");

            stringBuilder.append("\n\t\t\"age\": ");
            stringBuilder.append(user.age);
            stringBuilder.append(", ");

            stringBuilder.append("\n\t\t\"posts\": [");

            int count2 = 1;
            Post mostLikedPost = user.posts[0];
            for (Post post : user.posts) {
                if (post.likesCount > mostLikedPost.likesCount) {
                    mostLikedPost = post;
                }

                stringBuilder.append("\n\t\t\t{");

                stringBuilder.append("\n\t\t\t\t\"title\": \"");
                stringBuilder.append(post.title);
                stringBuilder.append("\",");

                stringBuilder.append("\n\t\t\t\t\"description\": \"");
                stringBuilder.append(post.description);
                stringBuilder.append("\",");

                stringBuilder.append("\n\t\t\t\t\"likes_count\": ");
                stringBuilder.append(post.likesCount);

                if (count2 == user.posts.length) {
                    stringBuilder.append("\n\t\t\t}");
                } else {
                    stringBuilder.append("\n\t\t\t},");
                }
                count2++;
            }
            stringBuilder.append("\n\t\t],");


            stringBuilder.append("\n\t\t\"most_liked_post\": {");
            stringBuilder.append("\n\t\t\t\"title\": \"");
            stringBuilder.append(mostLikedPost.title);
            stringBuilder.append("\",");
            stringBuilder.append("\n\t\t\t\"description\": \"");
            stringBuilder.append(mostLikedPost.description);
            stringBuilder.append("\",");
            stringBuilder.append("\n\t\t\t\"likes_count\": ");
            stringBuilder.append(mostLikedPost.likesCount);
            stringBuilder.append("\n\t\t}");

            if (count1 == users.length) {
                stringBuilder.append("\n\t}");
            } else {
                stringBuilder.append("\n\t},");
            }
            count1++;
        }
        stringBuilder.append("\n]");

        System.out.println(stringBuilder);
    }
}

class User {
    public int id;
    public String name;
    public int age;
    public Post[] posts;

    private static int serial = 1;

    public User(String name, int age, Post[] posts) {
        id = serial++;
        this.name = name;
        this.age = age;
        this.posts = posts;
    }
}

class Post {
    public int id;
    public String title;
    public String description;
    public int likesCount;

    private static int serial = 1;

    public Post(String title, String description, int likesCount) {
        id = serial++;
        this.title = title;
        this.description = description;
        this.likesCount = likesCount;
    }
}

