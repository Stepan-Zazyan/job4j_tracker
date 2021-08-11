package ru.job4j.tracker.profession;

public class Engineer extends Profession{

    private String construct;

    public Engineer(String construct, String name, String surname, String education, String birthday){
        super(name, surname, education, birthday);
        this.construct =construct;
    }

    public Engineer() {
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }
}
