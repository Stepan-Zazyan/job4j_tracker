package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
/*
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Value> values = Arrays.asList(Value.values());
        List<Card> list = Stream.of(suits)
                .flatMap(s -> Stream.of(new Card(suits.get(0), values.get(0))))
                .collect(Collectors.toList());
        list.forEach(System.out::println);*/
    }
}