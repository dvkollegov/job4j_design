package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }
        return array;
    }

    public static String multipleToString(int[][] arr) {
        StringBuilder str = new StringBuilder();
        for (int[] i : arr) {
            for (int j : i) {
                str.append(j).append(" ");
            }
            str.append(System.lineSeparator());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/multiple.txt")) {
            out.write(multipleToString(multiple(10)).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
