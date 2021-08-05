package ru.job4j.strategy;

public class Square implements Shape{
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    " _______" + ln
                + " |      |" + ln
                + " |      |" + ln
                + " _______" + ln;
    }
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());
    }
}
