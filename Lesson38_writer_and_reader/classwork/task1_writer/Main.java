package Lesson38_writer_and_reader.classwork.task1_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("reports" + File.separator + "test1.csv");

        List<Item> items = List.of(
                new Item("Предмет 1", 250),
                new Item("Предмет 2", 251),
                new Item("Предмет 3", 252),
                new Item("Предмет 4", 253),
                new Item("Предмет 5", 254)
        );

        writer.write("name,price\n");
        for (Item item : items) {
            writer.write(item.name() + "," + item.price() + "\n");
        }

        writer.close();
    }
}

record Item(String name, int price) {

}
