package ru.job4j.map;

import java.util.Objects;

public class Label implements Comparable<Label> {

    private String name;
    private int score;

    Label(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Label o) {
        return Integer.compare(this.score, o.score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return label.score == score && Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
