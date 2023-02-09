package ru.job4j.io;

import java.io.*;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            List<String> lines = in.lines().toList();
            boolean isWork = true;
            for (String line : lines) {
                String[] arr = line.split(" ");
                StringBuilder builder = new StringBuilder();
                if (isWork && ("400".equals(arr[0]) || "500".equals(arr[0]))) {
                    builder.append(arr[1]).append(";");
                    out.print(builder);
                    isWork = false;
                } else if (!isWork && ("200".equals(arr[0]) || "300".equals(arr[0]))) {
                    builder.append(arr[1]).append(";");
                    out.println(builder);
                    isWork = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
