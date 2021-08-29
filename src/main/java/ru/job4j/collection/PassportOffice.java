package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        return citizens.put(citizen.getPassport(), citizen)
                == citizens.putIfAbsent(citizen.getPassport(), citizen);
    }
    /*Сервис должен проверять, что гражданина с таким паспортом еще нет, а так же возможность получить информацию о гражданине по его паспорту.

    Метод add вернет true, если пользователя еще нет в HashMap. Если он уже есть, то вернуть false.

    Для решения этой задачи Вам потребуются методы Map.containsKey(key) и Map.get(key).*/


    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}