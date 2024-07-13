package Lesson28_comparator.classwork.task1;

import java.util.Comparator;

public class ItemPopularityComparator implements Comparator<ItemPopularityComparator.Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.popularity - item2.popularity;
    }

    static class Item {
        public final String name;
        public final int price;
        public final int popularity;

        public Item(String name, int price, int popularity) {
            this.name = name;
            this.price = price;
            this.popularity = popularity;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", popularity=" + popularity +
                    '}';
        }
    }
}

