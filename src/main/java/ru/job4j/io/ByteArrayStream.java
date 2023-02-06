package ru.job4j.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bt = new byte[]{'J', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bt);
        int read;
        while ((read = stream.read()) != -1) {
            System.out.print((char) read);
        }
        System.out.println();
        String str = "1234567890";
        byte[] bt1 = str.getBytes();
        ByteArrayInputStream stream1 = new ByteArrayInputStream(bt1, 3, 10);
        while ((read = stream1.read()) != -1) {
            System.out.print((char) read);
        }
        System.out.println();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bt2 = "New massage".getBytes();
        outputStream.writeBytes(bt2);
        System.out.println(outputStream);
        try (FileOutputStream fileOut = new FileOutputStream("data/message.txt")) {
            fileOut.write(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
