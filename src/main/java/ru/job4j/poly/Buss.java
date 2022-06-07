package ru.job4j.poly;

public class Buss implements Transport {

    @Override
    public void drive() {
        System.out.println("I can drive");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Passengers amount " + passengers);

    }

    @Override
    public int load(int count) {
        return 0;
    }
}
