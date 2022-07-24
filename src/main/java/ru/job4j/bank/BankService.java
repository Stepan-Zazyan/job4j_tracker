package ru.job4j.bank;

import java.util.*;

/**
 * модель для банковской системы
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод должен добавить пользователя в систему
     *
     * @param user Принимает параметр user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод должен добавить новый счет к пользователю
     *
     * @param passport Принимает String параметр паспорт
     * @param account  Принимает String параметр аккаунт
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
     * метод ищет пользователя по номеру паспорта:
     *
     * @param passport Принимает String параметр паспорт
     * @return Возвращает объект user, или null в случае его отсутствия
     */
    public User findByPassport(String passport) {

        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
        /*for (User x : users.keySet()) {
            if (x.getPassport().equals(passport)) {
                return x;
            }
        }
        return null;*/
    }

    /**
     * метод ищет счет пользователя по реквизитам
     *
     * @param passport  Принимает String параметр паспорт
     * @param requisite Принимает String параметр реквизиты
     * @return Возвращает реквизиты пользователя или null, если пользователя не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param srcPassport   Принимает String параметр паспорт отправителя
     * @param srcRequisite  Принимает String параметр реквизиты отправителя
     * @param destPassport  Принимает String параметр паспорт получателя
     * @param destRequisite Принимает String параметр реквизиты получателя
     * @param amount        Принимет double сумму перевода
     * @return Возвращает значение true в случае успешного перевода
     * и false, если перевод не был сделан
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