package Lesson41_functional_style.homework.task2;

import java.util.ArrayList;
import java.util.List;

public class CandyBox {
    final String boxTitle;
    final List<Candy> candies;
    final long numberOfCandies;

    private static final List<String> prohibitedProducers = List.of("Рахат");

    public CandyBox(String boxTitle, List<Candy> candies) {
        this.boxTitle = boxTitle;
        this.candies = candies.stream()
                .filter(CandyBox::isProducerAllowed)
                .map(candy -> new Candy(candy.name, candy.producer, candy.price - 5, candy.amountSold, candy.alternateNames))
                .sorted(Candy::compareByName)
                .toList();
        this.numberOfCandies = this.candies.size();
    }

    public static boolean isProducerAllowed(Candy candy) {
        return !prohibitedProducers.contains(candy.name);
    }

    public void printContent() {
        System.out.println("Набор " + boxTitle
                + ", содержит " + numberOfCandies + " конфет");
        candies.forEach(candy ->
                System.out.println(candy.name + " производства " + candy.producer + ", цена: " + candy.price));
    }
}
