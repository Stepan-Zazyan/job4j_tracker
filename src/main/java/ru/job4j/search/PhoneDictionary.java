package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    @Override
    public String toString() {
        return "PhoneDictionary {"
                +
                "persons = " + persons
                +
                '}';
    }

    public static void main(String[] args) {
        PhoneDictionary list = new PhoneDictionary();
        var man = new Person("Petr", "jk", "hj", "t");
        var woman = new Person("Anna", "jk", "hj", "t");
        list.add(man);
        list.add(woman);
        System.out.println(list.find("Petr"));
        System.out.println(man);
        System.out.println(list);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predByName = (t) -> t.getName().contains(key);
        Predicate<Person> predBySurname = (t) -> t.getSurname().contains(key);
        Predicate<Person> predByPhone = (t) -> t.getPhone().contains(key);
        Predicate<Person> predByAddress = (t) -> t.getAddress().contains(key);
        Predicate<Person> combine = predByName.or(predBySurname).or(predByPhone).or(predByAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
