package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account x : users.get(user)) {
                if (Objects.equals(x.getRequisite(), account.getRequisite())) {
                    System.out.println("аккаунт уже существует");
                    break;
                }
            }
            users.get(user).add(account);
        } else {
            System.out.println("пользователя не существует");
        }
    }

    public User findByPassport(String passport) {
        for (User x : users.keySet()) {
            if (x.getPassport().equals(passport)) {
                return x;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account x : users.get(user)) {
                if (Objects.equals(x.getRequisite(), requisite)) {
                    return x;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User srcUser = findByPassport(srcPassport);
        if (srcUser == null) {
            System.out.println("Данные паспорта исходного пользователя не верны");
            return false;
        }
        User destUser = findByPassport(destPassport);
        if (destUser == null) {
            System.out.println("Данные паспорта пользователя для перевода не верны");
            return false;
        }
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        boolean rsl = false;
        return rsl;
    }
}