package dz.geekbrains.java.lesson6.animals;

public class Animal {
    protected String name = "";
    protected int maxDistRun = -1; //Максимальная дистанция для бега; -1 означает отсутствие такой способности
    protected int maxDistSwim = -1; //Максимальная дистанция для плавания; -1 означает отсутствие плавания
    private static int animalsCount = 0; //Количество всех животных
    private static int catCount = 0;
    private static int dogCount = 0;

    protected Animal () {
        animalsCount++;

        if (this instanceof Cat) {
            catCount++;
        } else if (this instanceof Dog) {
            dogCount++;
        }
    }

    //Не совсем понял из задания где именно вести подсчёт
    //Чтобы вывести информацию обо всех животных, решил сделать в родителе
    public void getCountInfo () {
        System.out.println("Количество животных равно " + animalsCount + ".");
        System.out.println("\tИз них:");
        System.out.println("\t\t- котов: " + catCount);
        System.out.println("\t\t- собак: " + dogCount);
    }

    public void run(int distance) {
        if (maxDistRun < 0) {
            System.out.println(name + " не умеет бегать.");
        } else if (distance == 0) {
            System.out.println(name + " подпрыгнул на месте ... и никуда не побежал.");
        } else if (distance > maxDistRun) {
            System.out.println(name + " пробежал " + maxDistRun +
                    " метр" + fixEndDim(distance) + " и устал. Дальше он бежать не может.");
        } else if (distance < 0) {
            System.out.println(name + " не захотел бежать.");
        } else {
            System.out.println(name + " пробежал " + distance + " метр" + fixEndDim(distance) + ".");
        }
    }

    public void swim (int distance) {
        if (maxDistSwim < 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance == 0) {
            System.out.println(name + " просто плескается в воде и никуда не плывёт.");
        } else if (distance > maxDistSwim) {
            System.out.println(name + " проплыл " + maxDistSwim +
                    " метр" + fixEndDim(distance) + " и устал. Дальше он плыть не может.");
        } else if (distance < 0) {
            System.out.println(name + " не захотел плыть.");
        } else {
            System.out.println(name + " проплыл " + distance + " метр" + fixEndDim(distance) + ".");
        }
    }

    private String fixEndDim (int num) {
        //Возвращает окончание для размерности в зависимости от значения
        switch (num % 10) {
            case 1: return ""; //Например, 21 метр
            case 2:
            case 3:
            case 4: return "а"; //Например, 102 - 104 метра
            default: return "ов"; //Например, 55 метров
        }
    }
}
