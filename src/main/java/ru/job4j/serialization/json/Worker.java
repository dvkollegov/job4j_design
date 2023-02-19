package ru.job4j.serialization.json;

import java.util.Arrays;

public class Worker {
    private final String name;
    private final int age;
    private final boolean health;
    private final Car car;
    private final String[] skill;

    public Worker(String name, int age, boolean health, Car car, String[] skill) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.car = car;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHealth() {
        return health;
    }

    public Car getCar() {
        return car;
    }

    public String[] getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return "Worker{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", health=" + health
                + ", car=" + car
                + ", skill=" + Arrays.toString(skill)
                + '}';
    }
}
