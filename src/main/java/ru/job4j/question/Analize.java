package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int add = 0;
        int chan = 0;
        int del = 0;
        Map<Integer, User> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user);
        }
        for (User cur : current) {
            if (!map.containsKey(cur.getId())) {
                add++;
            }
            if (!map.containsValue(cur) && map.containsKey(cur.getId())) {
                chan++;
            }
            map.remove(cur.getId());
        }
        del = map.size();
        return new Info(add, chan, del);
    }
}
