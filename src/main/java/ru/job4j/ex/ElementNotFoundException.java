package ru.job4j.ex;

import java.util.Objects;

public class ElementNotFoundException extends Exception{

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
    int rsl = -1;
    for (int i = 0; i < value.length; i++) {
        if (Objects.equals(value[i], key)) {
            rsl = i +1;
        } else if (key == null) {
            throw new ElementNotFoundException();
        }
    }
    return rsl;}

    public static void main(String[] args) {
        try {
            indexOf(null, "key");
    } catch (ElementNotFoundException e) {
        e.printStackTrace();
        }
    }
}

