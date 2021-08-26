package dz.lesson1_hard;

public class Main {
    public static void main(String[] args) {
        double katet1 = 3;
        double katet2 = 4;
        System.out.println(getHypotenuseLength(katet1, katet2));
    }

    private static double getHypotenuseLength(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }
}
