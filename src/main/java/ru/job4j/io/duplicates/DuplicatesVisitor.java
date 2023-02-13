package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty property = new FileProperty(file.toFile().length(), file.toFile().getName());
        map.putIfAbsent(property, new ArrayList<>());
        map.get(property).add(file);
        return CONTINUE;
    }

    public void print() {
        Map<FileProperty, List<Path>> rsl = map.entrySet().stream()
                .filter(f -> f.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<FileProperty, List<Path>> entry : rsl.entrySet()) {
            System.out.printf("%s - %s bytes%n", entry.getKey().getName(), entry.getKey().getSize());
            entry.getValue().forEach(System.out::println);
        }
    }
}
