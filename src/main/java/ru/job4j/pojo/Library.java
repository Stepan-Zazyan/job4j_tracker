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
        for (Book obj : array) {
            System.out.println(obj.getName() + " " + obj.getPages());
        }
        System.out.println();
        Book tmp = array[0];
        array[0] = array[3];
        array[3] = tmp;
        for (Book book : array) {
            System.out.println(book.getName() + " " + book.getPages());
        }
        System.out.println();
        for (Book obj: array) {
            if ("Clean code Book".equals(obj.getName())) {
                System.out.println(obj.getName() + " " + obj.getPages());
            }
        }
    }
}
