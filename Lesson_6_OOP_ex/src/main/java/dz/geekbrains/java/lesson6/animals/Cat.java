package dz.geekbrains.java.lesson6.animals;

public class Cat extends Animal {
    public Cat (String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            this.name = "Кот";
        }

        this.maxDistRun = 200;
    }
}
