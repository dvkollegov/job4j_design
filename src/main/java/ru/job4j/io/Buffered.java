package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("data/print.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("data/output.txt", true))) {
            int count;
            while ((count = in.read()) > 0) {
                out.write(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
