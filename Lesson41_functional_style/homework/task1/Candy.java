package Lesson41_functional_style.homework.task1;

import java.util.Collection;
import java.util.Set;

public class Candy {
    final String name;
    final String producer;
    final int price;
    final int amountSold;
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

    public static int compareByPrice(Candy c1, Candy c2) {
        //вставьте код здесь
        return c1.price - c2.price;
    }

    public void printNameWithPrice() {
        System.out.println(this.name + " - " + this.price);
        //вставьте код здесь
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", amountSold=" + amountSold +
                ", alternateNames=" + alternateNames +
                '}';
    }
}
