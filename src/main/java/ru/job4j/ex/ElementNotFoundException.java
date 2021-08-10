package ru.job4j.ex;

public class ElementNotFoundException extends Exception {

    public static void indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
           if (rsl == -1) {
            throw new ElementNotFoundException();
        }

    }

    public static void main(String[] args) {
        try {
            indexOf(null, "key");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

