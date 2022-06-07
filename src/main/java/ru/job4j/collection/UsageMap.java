package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> testcoll = new HashMap<>();
        testcoll.put("stepanzazyan@yandex.ru", "Stepan Sem");
        testcoll.put("stepanzazyan@gmail.com", "Victor Step");
        for (Map.Entry<String, String> key : testcoll.entrySet()) {
            System.out.println(key.getKey() + " " + key.getValue());
        }
    }
}
