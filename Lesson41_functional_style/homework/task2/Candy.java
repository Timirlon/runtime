package Lesson41_functional_style.homework.task2;

import java.util.Collection;
import java.util.Set;

public class Candy {
    //название
    final String name;
    //производитель
    final String producer;
    //цена
    final int price;
    //проданное количество
    final int amountSold;
    //другие варианты названия
    final Set<String> alternateNames;

    public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.amountSold = amountSold;
        this.alternateNames = Set.copyOf(alternateNames);
    }

    public static int compareByName(Candy c1, Candy c2) {
        return c1.name.compareTo(c2.name);
    }
}
