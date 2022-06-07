package ru.job4j.tracker.profession;

public class Programmer extends Engineer {

    private String program;

    public Programmer(String program, String construct, String name,
                      String surname, String education, String birthday) {
        super(construct, name, surname, education, birthday);
        this.program = program;
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }
}
