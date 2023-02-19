package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "worker")
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private boolean health;
    private Car car;
    @XmlElementWrapper(name = "skilles")
    @XmlElement(name = "skill")
    private String[] skill;

    public Worker() {
    }

    public Worker(String name, int age, boolean health, Car car, String[] skill) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.car = car;
        this.skill = skill;
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

    public static void main(String[] args) throws JAXBException {
        final Worker person = new Worker("John Smith", 37, true,
                new Car("BMW", 123), new String[] {"driver", "carpenter", "plumber"});
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
