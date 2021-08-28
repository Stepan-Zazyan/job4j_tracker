package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> originCheck = new HashSet<>();
        for (String s: origin) {
            originCheck.add(s);
        } ;
        for (String s : text) {
            if (!originCheck.contains(s)) {
                rsl = false;
            }
        }
        return rsl;
    }
}

/*
    В HashSet надо переводить только первый массив

        и делайте это в цикле for-each

        Второй массив перебирайте в цикле for-each

        for (String s : text) {

        и внутри будет проверка

        if (!originCheck.contains(s)) {

        и внутри строка

        return false*/
