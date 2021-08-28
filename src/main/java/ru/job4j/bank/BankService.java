package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account s : list) {
            if (Objects.equals(s.getRequisite(), account.getRequisite())) {
                break;
            } else {
                list.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        User user = new User();
        for (User s : users.keySet()) {
            if (Objects.equals(s.getPassport(), passport)) {
                user = s;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = new Account();
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account s : list) {
            if (Objects.equals(s.getRequisite(), requisite)) {
                account = s;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getBalance() < amount || srcAccount.getRequisite() == null) {
            rsl = false;
        } else {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }
}