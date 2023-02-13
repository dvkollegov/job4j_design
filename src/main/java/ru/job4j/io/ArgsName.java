package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private boolean checkLine(String arg) {
        int count = arg.length() - arg.replace("=", "").length();
        return arg.startsWith("=") || !arg.contains("=") || (count == 1 && arg.endsWith("="))
                || !arg.startsWith("-") || arg.substring(1).startsWith("=");
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            arg.trim();
            if (checkLine(arg)) {
                throw new IllegalArgumentException();
            }
            String[] arr = arg.split("=", 2);
            values.put(arr[0].substring(1), arr[1]);
        }
    }

    public static ArgsName of(String[] args) {
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
