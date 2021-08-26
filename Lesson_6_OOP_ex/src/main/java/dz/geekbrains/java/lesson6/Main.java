package dz.geekbrains.java.lesson6;

import dz.geekbrains.java.lesson6.animals.Animal;
import dz.geekbrains.java.lesson6.animals.Cat;
import dz.geekbrains.java.lesson6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat ("Петрович");
        Dog dog = new Dog("Патрон");
        Cat cat2 = new Cat (null);
        Cat cat3 = new Cat (null);
        Dog dog2 = new Dog(null);

        cat.run (31);
        cat.swim(0);

        dog.run (999);
        dog.swim(5);

        System.out.println();
        cat.getCountInfo();
    }
}
