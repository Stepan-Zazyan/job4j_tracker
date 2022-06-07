package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /*    Нашли пользователя проверили на null, потом извлекли список аккаунтов.
        Проверили есть в нем добавляемый аккаунт или нет с помощью contains,
        и если его нет - то добавляем аккаунт в список*/
    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> list = users.get(user);
            if (!list.contains(user)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User s : users.keySet()) {
            if (Objects.equals(s.getPassport(), passport)) {
                user = s;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        if (findByPassport(passport) != null) {
            User user = findByPassport(passport);
            List<Account> list = users.get(user);
            for (Account s : list) {
                if (Objects.equals(s.getRequisite(), requisite)) {
                    account = s;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getBalance() >= amount && srcAccount.getRequisite() != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}