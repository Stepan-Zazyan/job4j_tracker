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
        Person man = new Person("Petr", "jk", "hj", "t");
        Person woman = new Person("Anna", "jk", "hj", "t");
        list.add(man);
        list.add(woman);
        System.out.println(list.find("Petr"));
        System.out.println(man);
        System.out.println(list);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = (t) -> t.getName().contains(key)
                || t.getSurname().contains(key)
                || t.getPhone().contains(key)
                || t.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
