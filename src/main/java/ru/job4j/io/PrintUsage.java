package ru.job4j.io;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream ps = new PrintStream("data/print.txt");
             PrintWriter pw = new PrintWriter("data/write.txt")) {
            ps.println("Из PrintStream в FileOutputStream ");
            ps.write("Новая строка".getBytes());
            pw.println("Новое сообщение");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
