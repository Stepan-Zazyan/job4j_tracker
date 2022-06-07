package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван");
        student.setGroup(123);
        student.setDate(LocalDateTime.now());
        System.out.println(student.getName() + " из группы " + student.getGroup()
                +                " зачислен " + student.getDate());
    }
}
