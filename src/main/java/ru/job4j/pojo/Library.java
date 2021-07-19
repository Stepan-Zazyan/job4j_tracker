package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book frodo = new Book("Lord", 2);
        Book sam = new Book("Potter", 43);
        Book gendalf = new Book("Rings", 11);
        Book cleanCode = new Book("Clean code Book", 6575);
        Book[] array = new Book[4];
        array[0] = frodo;
        array[1] = sam;
        array[2] = gendalf;
        array[3] = cleanCode;
        for (int i = 0; i < array.length; i++) {
            Book obj = array[i];
            System.out.println(obj.getName() + " " + obj.getPages());
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName().equals("Clean code Book")) {
                System.out.println(array[i].getName() + " " + array[i].getPages());
            }
        }
    }
}
