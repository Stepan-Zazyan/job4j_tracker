package ru.job4j.lombok;

public class LombokUsage {
        public static void main(String[] args) {
            BirdData bird = new BirdData();
            bird.setAge(1);
            System.out.println(bird);
            Permission permission = Permission.someName()
                    .id(1)
                    .name("build")
                    .rules("rule").build();
            System.out.println(permission);
        }
}
