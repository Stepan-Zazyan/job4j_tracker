package ru.job4j.tracker.profession;

import ru.job4j.tracker.profession.Doctor;

public class Surgeon extends Doctor {

    private String cut;

    public Surgeon(String cut, String cure, String name, String surname,
                   String education, String birthday) {
        super(cure, name, surname, education, birthday);
        this.cut = cut;
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }
}
