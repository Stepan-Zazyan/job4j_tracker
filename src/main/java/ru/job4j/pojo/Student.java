package ru.job4j.pojo;

import java.time.LocalDateTime;

public class Student {

    private String name;
    private int group;
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public void setName(String enterName) {
        this.name = enterName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
