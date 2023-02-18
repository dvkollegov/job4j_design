package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Dmitriy Kollegov";
        byte age = 37;
        short weight = 80;
        int height = 185;
        long distance = 10_000;
        double debit = 5000.0D;
        float credit = 1000.0F;
        char symbol = 'A';
        boolean isWork = true;
        LOG.debug("User info name : {}, age : {}, weight : {}, height : {}, "
                        + "symbol : {}, work : {}, distance : {}, debit : {}, credit : {}",
                        name, age, weight, height, symbol, isWork, distance, debit, credit);
    }
}
