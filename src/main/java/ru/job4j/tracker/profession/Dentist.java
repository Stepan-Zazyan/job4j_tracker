package ru.job4j.tracker.profession;

import ru.job4j.tracker.profession.Doctor;

public class Dentist extends Doctor {

    private String teeth;

    public Dentist(String teeth, String cure, String name, String surname,
                   String education, String birthday) {
        super(cure, name, surname, education, birthday);
        this.teeth = teeth;
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }
}
