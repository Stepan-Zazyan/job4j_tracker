package ru.job4j.tracker1.profession;

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
