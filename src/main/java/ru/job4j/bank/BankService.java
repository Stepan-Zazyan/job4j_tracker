package ru.job4j.bank;

import java.util.*;

/**
 *модель для банковской системы
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *Этот метод должен добавить пользователя в систему
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     *метод должен добавить новый счет к пользователю
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(user)) {
                list.add(account);
            }
        }
    }

    /**
     *метод ищет пользователя по номеру паспорта:
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        for (User x : users.keySet()) {
            if (x.getPassport().equals(passport)) {
                return x;
            }
        }
        return null;
    }

    /**
     *метод ищет счет пользователя по реквизитам
     * @param passport
     * @param requisite
     * @return
     */
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

    /**
     *метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}