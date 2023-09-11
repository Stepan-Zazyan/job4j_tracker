package ru.job4j.trackerdb.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Item {

    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now().withNano(0);

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, LocalDateTime created) {
        this.name = name;
        this.created = created;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created.withNano(0);
    }

}
