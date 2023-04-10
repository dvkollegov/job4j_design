package ru.job4j.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CriteriaSearch {
    public void searchFile(ArgsName argsName) throws IOException {
        List<Path> paths = new ArrayList<>();
        if (argsName.get("t").equals("name")) {
            paths = Search.search(Paths.get(argsName.get("d")), p -> p.toFile().getName().contains(argsName.get("n")));
        }
        if (argsName.get("t").equals("mask")) {
            String pattern = argsName.get("n").replace("*", "\\w+").replace("?", "\\w{1}");
            paths = Search.search(Paths.get(argsName.get("d")), p -> p.toFile().getName().matches(pattern));
        }
        write(paths, argsName);
    }

    public void write(List<Path> paths, ArgsName argsName) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path path : paths) {
                out.write(path.toFile().getAbsolutePath());
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void valid(ArgsName argsName) {
        if (!new File(argsName.get("d")).isDirectory()) {
            throw new IllegalArgumentException("Directory not found");
        }
        if (!argsName.get("n").startsWith(".") && !argsName.get("n").startsWith("*")) {
            throw new IllegalArgumentException("Source file not found");
        }
        if (!argsName.get("t").contains("mask") && !argsName.get("t").contains("name")
                && !argsName.get("t").contains("regex")) {
            throw new IllegalArgumentException("Search type not correct");
        }
        if (!argsName.get("o").endsWith(".txt")) {
            throw new IllegalArgumentException("Target file not found");
        }
    }

    public static void main(String[] args) throws IOException {
        CriteriaSearch criteriaSearch = new CriteriaSearch();
        ArgsName argsName = ArgsName.of(args);
        criteriaSearch.valid(argsName);
        criteriaSearch.searchFile(argsName);
    }
}
