package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    private boolean checkLine(String line) {
        int count = line.length() - line.replace("=", "").length();
        return line.startsWith("=") || !line.contains("=") || (count == 1 && line.endsWith("="));
    }

    private boolean checkLineIsEmptyAndComment(String line) {
        return line.isEmpty() || line.startsWith("#");
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            for (String line : in.lines().toList()) {
                line.trim();
                if (checkLineIsEmptyAndComment(line)) {
                    continue;
                }
                if (checkLine(line)) {
                    throw new IllegalArgumentException();
                }
                String[] arr = line.split("=", 2);
                values.put(arr[0], arr[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
