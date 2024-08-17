package Lesson38_writer_and_reader.classwork.task3_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("reports\\test1.csv"));

        List<Item> items = new ArrayList<>();

        bf.readLine();

        while (bf.ready()) {
            String item = bf.readLine();
            String[] split = item.split(",");
            int price = Integer.parseInt(split[1]);
            items.add(new Item(split[0], price));
        }

        Item mostExpensiveItem = items.get(0);

        for (Item item : items) {
            if (item.price() > mostExpensiveItem.price()) {
                mostExpensiveItem = item;
            }
        }

        System.out.println(mostExpensiveItem);
    }
}

record Item(String name, int price) {

}
