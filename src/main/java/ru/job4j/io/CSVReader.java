package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {

    private static void checkArgs(ArgsName argsName) {
        if (!Files.isRegularFile(Paths.get(argsName.get("path")))) {
            throw new IllegalArgumentException("Root file address is not set correctly.");
        }
        if (!";".equals(argsName.get("delimiter")) && !",".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Wrong delimiter need used only ';' or ','");
        }
        if (!"stdout".equals(argsName.get("out")) && !argsName.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException("Can't write to a file or output to the console.");
        }
        if (argsName.get("filter").length() == 0) {
            throw new IllegalArgumentException("Incorrect data for the filter.");
        }
    }

    public static void handle(ArgsName argsName) {
        List<String> list = new ArrayList<>();
        List<String> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(argsName.get("path")))) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] filter = argsName.get("filter").split(",");
        String[] headLine = list.get(0).split(argsName.get("delimiter"));
        List<Integer> index = new ArrayList<>();
        for (String s : filter) {
            for (int j = 0; j < headLine.length; j++) {
                if (s.equals(headLine[j])) {
                    index.add(j);
                }
            }
        }
        for (String s : list) {
            StringJoiner joiner = new StringJoiner(argsName.get("delimiter"));
            String[] arr = s.split(argsName.get("delimiter"));
            for (Integer i : index) {
                joiner.add(arr[i]);
            }
            rsl.add(String.valueOf(joiner));
        }
        if (!"stdout".equals(argsName.get("out"))) {
            try (PrintWriter out = new PrintWriter(new FileWriter(argsName.get("out")))) {
                for (String s : rsl) {
                    out.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("stdout".equals(argsName.get("out"))) {
            for (String s : rsl) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder has a value not equal to four. Usage ROOT_FOLDER.");
        }
        checkArgs(ArgsName.of(args));
        handle(ArgsName.of(args));
    }
}
