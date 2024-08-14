package Lesson37_exceptions_and_files.classwork.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FIleCreation {
    public static void main(String[] args) throws IOException {
        Path reportsDirectory = Paths.get("reports");

        if (!Files.exists(reportsDirectory)) {
            Files.createDirectory(reportsDirectory);
        }

        for (int i = 1; i <= 4; i++) {
            Path reportFiles = reportsDirectory.resolve("report"  + i +".txt");
            if (!Files.exists(reportFiles)) {
                Files.createFile(reportFiles);
            }
        }
    }
}
