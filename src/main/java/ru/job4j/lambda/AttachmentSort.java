package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                Attachment left = (Attachment) o;
                Attachment right = (Attachment) t1;
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
    }
}