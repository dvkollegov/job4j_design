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

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            List<String> lines = in.lines().toList();
            for (String line : lines) {
                if (line.startsWith("=")) {
                    throw new IllegalArgumentException();
                }
                String[] arr = line.split("=");
                if (!(line.isEmpty() || line.contains("#")) && (arr.length == 1 || !line.contains("="))) {
                    throw new IllegalArgumentException();
                }
                if (arr.length == 2) {
                    values.put(arr[0], arr[1]);
                }
                if (arr.length > 2) {
                    StringJoiner joiner = new StringJoiner("=");
                    for (int i = 1; i < arr.length; i++) {
                        joiner.add(arr[i]);
                    }
                    values.put(arr[0], joiner.toString());
                }
                if (arr.length > 2 && line.endsWith("=")) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < arr.length; i++) {
                        builder.append(arr[i]).append("=");
                    }
                    values.put(arr[0], builder.toString());
                }
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
