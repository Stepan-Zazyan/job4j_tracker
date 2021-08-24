package ru.job4j.search;


import ru.job4j.tracker.StubOutput;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    @Override
    public String toString() {
        return "PhoneDictionary {" +
                "persons = " + persons +
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
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) ||
                    person.getPhone().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
