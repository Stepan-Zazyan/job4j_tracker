package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
      return "Неизвестное слово." + eng;
    }

    public static void main(String[] args) {
        DummyDic Dic = new DummyDic();
        String say = Dic.engToRus(" Unknown word");
        System.out.println(say);
    }
}
