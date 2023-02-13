package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String rsl = "";
        for (String s : values.keySet()) {
            if (!s.equals(key)) {
                throw new IllegalArgumentException("Not valid key");
            }
            rsl = values.get(key);
            break;
        }
        return rsl;
    }

    private void checkLine(String arg) {
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException("String must start with the character \"-\"");
        }
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("String must contain the character \"=\"");
        }
        if (arg.startsWith("=")) {
            throw new IllegalArgumentException("String must contain the key");
        }
        if (arg.startsWith("-=")) {
            throw new IllegalArgumentException("String must not start with characters \"-=\"");
        }
        int count = arg.length() - arg.replace("=", "").length();
        if ((count == 1 && arg.endsWith("="))) {
            throw new IllegalArgumentException("String must contain the value");
        }
    }

    private void parse(String[] args) {
        for (String arg : args) {
            arg.trim();
            checkLine(arg);
            String[] arr = arg.split("=", 2);
            values.put(arr[0].substring(1), arr[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty array of arguments");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
