package dz.lesson2;

public class Main {
    public static void main(String[] args) {
        //System.out.println(isSumTrue(10, 11));
        //printStatusNum(-1);
        //System.out.println(isStatusNum(-1));
        //printStringNTimes("Hello", -1);
        //System.out.println(isLeapYear(2101));
    }

    public static boolean isSumTrue (int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20) ? true : false;
    }

    public static void printStatusNum (int num) {
        if (num >= 0) {
            System.out.println("Переданное число положительное");
        } else {
            System.out.println("Переданное число отрицательное");
        }
    }

    public static boolean isStatusNum (int num) {
        return (num < 0) ? true : false;
    }

    public static void printStringNTimes (String str, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(str);
            }
        }
    }

    public static boolean isLeapYear (int year) {
        if (year > 0) {
            if (year % 4 == 0) { //Предположительно год високосный
                if (year % 100 == 0 && year % 400 != 0) { //Каждый 100-й отпадает, кроме 400-го
                    return false;
                }
                return true;
            }
        }

        return false;
    }
}
