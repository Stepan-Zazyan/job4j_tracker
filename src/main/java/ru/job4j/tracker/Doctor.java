package ru.job4j.tracker;

public class Doctor extends Profession{

    private String cure;

    public Doctor(String cure, String name, String surname, String education, String birthday){
        super(name, surname, education, birthday);
        this.cure = cure;
    }

    public Doctor() {
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
