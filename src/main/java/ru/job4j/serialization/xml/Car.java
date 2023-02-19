package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Car {
    @XmlAttribute
    private String brand;
    @XmlAttribute
    private int number;

    public Car() {
    }

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
