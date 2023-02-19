package ru.job4j.serialization.json;

public class Car {
    private final String brand;
    private final int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", number=" + number
                + '}';
    }
}
