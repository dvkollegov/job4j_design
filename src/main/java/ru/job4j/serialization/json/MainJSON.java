package ru.job4j.serialization.json;

import com.google.gson.Gson;
import org.json.JSONObject;

public class MainJSON {
    public static void main(String[] args) {
        final Worker worker = new Worker("John Smith", 37, true,
                new Car("BMW", 123), new String[] {"driver", "carpenter", "plumber"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", worker.getName());
        jsonObject.put("age", worker.getAge());
        jsonObject.put("health", worker.isHealth());
        jsonObject.put("car", worker.getCar());
        jsonObject.put("skill", worker.getSkill());
        System.out.println(jsonObject);
        System.out.println(new JSONObject(worker));
        String workerNewStr = new JSONObject(worker).toString();
        Worker workerNew = new Gson().fromJson(workerNewStr, Worker.class);
        System.out.println(workerNew);
    }
}
