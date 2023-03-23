package FileSearch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSearch extends SimpleFileVisitor<Path> {
        private ArrayList<Path> pathFileJSON;
        private ArrayList<Path> pathFileCSV;


    public FileSearch() {
        pathFileJSON = new ArrayList<>();
        pathFileCSV = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<String> lines = Files.readAllLines(file);
        for (String string: lines) {
            if (string.contains("name,date")) {
                pathFileCSV.add(file.toAbsolutePath());
                break;
            } else if (string.contains("[")) {
                pathFileJSON.add(file.toAbsolutePath());
                break;
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public ArrayList<Path> getPathFilesCSV() {
        return new ArrayList<>(pathFileCSV);
    }

    public ArrayList<Path> getPathFilesJSON() {
        return new ArrayList<>(pathFileJSON);
    }
}
