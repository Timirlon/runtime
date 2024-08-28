package Lesson41_functional_style.homework.task2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CandyBoxesStore {
    public static void main(String[] args) {
        Candy candy1 = new Candy("Рахат", "Рахат", 140, 4, Set.of("Рафаэлло", "Қарақұм"));
        Candy candy2 = new Candy("Шокобар", "Баян Сұлу", 160, 2, Set.of("Шоко", "Баян"));
        Candy candy3 = new Candy("Ақ Тілегім", "Рахат", 220, 5, Set.of("Ақ тілегім", "Ақ тілек"));
        Candy candy4 = new Candy("Тайжану", "Баян Сұлу", 70, 12, Set.of("ТАЙЖАНУ"));

        List<Candy> candies = List.of(candy1, candy2, candy3, candy4);

        List<Candy> candiesForBox = List.of(candy1, candy2, candy3, candy4);

                CandyBox candyBox = new CandyBox("С Новым Годом", candiesForBox);

        candyBox.printContent();
    }
}
