package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private FileProperty fileProperty;
    private List<Path> list = new ArrayList<>();

    public DuplicatesVisitor(FileProperty file) {
        this.fileProperty = file;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (String.valueOf(file.getFileName()).equals(fileProperty.getName()) && Files.size(file) == fileProperty.getSize()) {
            list.add(file.toAbsolutePath());
        }
        return CONTINUE;
    }

    public void print() {
        System.out.printf("%s - %s byte%n", fileProperty.getName(), fileProperty.getSize());
        for (Path s : list) {
            System.out.println(s);
        }
    }
}
