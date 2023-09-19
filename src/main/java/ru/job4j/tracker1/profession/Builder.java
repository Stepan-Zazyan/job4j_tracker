package ru.job4j.tracker1.profession;

public class Builder extends Engineer {

    private  String build;

    public  Builder(String build, String construct, String name, String surname,
                    String education, String birthday) {
        super(construct, name, surname, education, birthday);
        this.build = build;
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }
}
