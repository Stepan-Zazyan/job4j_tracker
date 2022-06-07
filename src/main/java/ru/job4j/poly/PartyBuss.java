package ru.job4j.poly;

public class PartyBuss implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Проводит вечеринки");
    }
}
