package dz.geekbrains.java.lesson6.animals;

public class Dog extends Animal {
    public Dog (String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            this.name = "Пёсик";
        }

        this.maxDistRun = 500;
        this.maxDistSwim = 10;
    }
}
