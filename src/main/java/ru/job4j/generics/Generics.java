package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        /*
        * gen.printBoundedWildCard(first);
        *
        * не можем использовать метод printBoundedWildCard для печати объета first т.к.
        * объект first пренадлежит типу Animal, а данный метод печатает только объекты
        * типа Predator и объекты типов которым является родителем (суперклассом) - Tiger.
        */
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
        /*
        * gen.printLowerBoundedWildCard(third);
        *
        * не можем использовать метод printLowerBoundedWildCard для печати объета third т.к.
        * объект third пренадлежит типу Tiger, данный класс наследуется от класса Predator,
        * а данный метод печатает только объекты типа Predator и объекты типов от которых сам наследуется - Animal.
        */
    }

    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}
