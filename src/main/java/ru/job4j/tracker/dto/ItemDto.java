package ru.job4j.tracker.dto;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {

    private int id;

    private String name;

    private LocalDateTime expired;
}
