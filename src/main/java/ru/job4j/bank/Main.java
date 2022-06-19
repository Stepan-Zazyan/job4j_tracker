package ru.job4j.bank;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**
        *Пишем объекты
         */
        List<Account> accountListStepan = new ArrayList<>();
        List<Account> accountListPetya = new ArrayList<>();
        Account accountOne = new Account("реквизиты 1", 111.11);
        Account accountTwo = new Account("реквизиты 2", 222.22);
        Account accountThree = new Account("реквизиты 3", 333.33);
        Account accountFour = new Account("реквизиты 4", 444.44);
        accountListStepan.add(accountOne);
        accountListStepan.add(accountTwo);
        accountListPetya.add(accountThree);
        accountListPetya.add(accountFour);
        User stepan = new User("passport Stepan", "name Stepan");
        User petya = new User("passport Petya", "name Petya");
        Map<User, List<Account>> users = new HashMap<>();

        /**
         *Манипуляции с объектами
         * */
        users.put(stepan, accountListStepan);
        System.out.println(users.values());
        users.putIfAbsent(stepan, accountListPetya);
        System.out.println(users.values());
        System.out.println(users.containsKey(stepan));
        users.putIfAbsent(petya, accountListPetya);
        boolean empty = users.isEmpty();
        System.out.println(empty);
        Map<User, List<Account>> users2 = new HashMap<>(users);
        System.out.println(users2.values());
        System.out.println(users2);
        System.out.println(users.get(stepan));
    }
}
