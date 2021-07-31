package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle partybuss = new PartyBuss();
        Vehicle[] array = new Vehicle[]{train, airplane, partybuss};
        for (Vehicle a: array) {
            a.move();
        }
    }
}
