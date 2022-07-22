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
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Value> values = Arrays.asList(Value.values());
        Stream.of(suits)
                .map(t->t.stream())
                .flatMap(s -> Stream.of(values))
                .map(k->k.stream())
                .flatMap(l->new Card(t,k))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}