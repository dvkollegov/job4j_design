package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder str = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                str.append((char) read);
            }
            String[] line = str.toString().split(System.lineSeparator());
            for (String s : line) {
                boolean rsl = Integer.parseInt(s) % 2 == 0;
                System.out.println(s + ": " + rsl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
