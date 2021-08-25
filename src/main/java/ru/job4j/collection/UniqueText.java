package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> originCheck = new HashSet<>(Arrays.asList(origin));
        HashSet<String> textCheck = new HashSet<>(Arrays.asList(text));
        for (String s: originCheck) {
            rsl = textCheck.contains(s);
        }
        return rsl;
    }
}
