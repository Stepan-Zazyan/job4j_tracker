package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error lies = new Error(false, 0, "none");
        Error truth = new Error(true, 1, "done");
        Error soso = new Error(true, 0, "what");
        lies.show();
        truth.show();
        soso.show();
    }
}