package Lesson34_string_part3_split_and_join.classwork.task6_join;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FriendsOutput {
    public static void main(String[] args) {
        Map<String, String> friends = new LinkedHashMap<>();
        friends.put("Сергей", "Астана");
        friends.put("Андрей", "Москва");
        friends.put("Дмитрий", "Питер");
        friends.put("Айбек", "Астана");

// Ваши друзья: Сергей, Андрей, Дмитрий, Айбек
// Ваши друзья в городах: Астана, Москва, Питер

        String friendsNames = String.join(", ", friends.keySet());
        System.out.println("Ваши друзья: " + friendsNames);

        Set<String> friendsCitySet = new LinkedHashSet<>(friends.values());

        String friendsCities = String.join(", ", friendsCitySet);
        System.out.println("Ваши друзья в городах: " + friendsCities);
    }
}
