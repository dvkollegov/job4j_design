package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Worker worker = new Worker("John Smith", 37, true,
                new Car("BMW", 123), new String[] {"driver", "carpenter", "plumber"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(worker);
        System.out.println(gson.toJson(worker));
        final String workerJson = "{"
                + "\"name\":\"Clark White\","
                + "\"age\":25,"
                + "\"health\":false,"
                + "\"car\":{\"brand\":\"Ford\",\"number\":567},"
                + "\"skill\":[\"driver\",\"painter\",\"electrician\"]}";
        final Worker workerMod = gson.fromJson(workerJson, Worker.class);
        System.out.println(workerMod);
        System.out.println(gson.toJson(workerMod));
    }
}
