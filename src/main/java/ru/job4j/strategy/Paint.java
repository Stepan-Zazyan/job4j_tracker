package ru.job4j.strategy;

public class Paint {
    public void drawShape(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.drawShape(new Triangle());
        context.drawShape(new Square());
    }
}
