package dz.lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//---------- Пункт 1 -----------
        int [] arr = {0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1};
        //System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr [i] == 0) {
                arr [i] = 1;
            } else if (arr [i] == 1) {
                arr [i] = 0;
            }
        }
        //System.out.println(Arrays.toString(arr));

//---------- Пункт 2 -----------
        int [] arr100 = new int [100];

        for (int a = 0; a < 100; a++) {
            arr100 [a] = a + 1;
        }
        //System.out.println(Arrays.toString(arr100));

//---------- Пункт 3 -----------
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        //System.out.println(Arrays.toString(arr3));
        for (int i3 = 0; i3 < arr3.length; i3++) {
            if (arr3 [i3] < 6) {
                arr3 [i3] *= 2;
            }
        }
        //System.out.println(Arrays.toString(arr3));

//---------- Пункт 4 -----------
        int [][] arr4 = new int [10][10];

        for (int i4 = 0; i4 < arr4.length; i4++) {
            for (int j4 = 0; j4 < arr4 [0].length; j4++) {
                if (i4 == j4 || i4 == (arr4 [0].length - 1 - j4)) {
                    arr4 [i4][j4] = 1;
                }
            }
        }

        /*for (int m = 0; m < arr4.length; m++) {
            System.out.println(Arrays.toString(arr4 [m]));
        }*/

//---------- Пункт 5 -----------
        int [] arr5 = arrayCreateAndInit(8, 99);
        /*if (testArr != null) {
            System.out.println(Arrays.toString(testArr));
        }*/

//---------- Пункт 6 -----------
        int [] arr6 = {5, 85, 195, -100, -2, 7, 194};
        int min6 = arr6 [0], max6 = arr6 [0];

        for (int i6 = 0; i6 < arr6.length; i6++) {
            if (arr6 [i6] < min6) {
                min6 = arr6 [i6];
            }
            if (arr6 [i6] > max6) {
                max6 = arr6 [i6];
            }
        }

        //System.out.println(Arrays.toString(arr6) + "\nМин: " + min6 + "\nМакс: " + max6);

//---------- Пункт 7 -----------
        int [] arr7 = new int [5];
        for (int i7 = 0; i7 < arr7.length; i7++) {
            arr7 [i7] = (int)(Math.random() * 3);
        }
        //System.out.println(Arrays.toString(arr7));
        System.out.println(checkLeftAndRight(arr7));

//---------- Пункт 8 -----------
        int [] arr8 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr8));

        displaceArray(arr8, -2);
        System.out.println(Arrays.toString(arr8));

        /*displaceArray(arr8, -5);
        System.out.println(Arrays.toString(arr8));*/

    }

    public static void displaceArray (int [] arr, int value) {
        if (arr != null && arr.length > 0 && (value % arr.length) != 0) {
            int realValue = Math.abs (value % arr.length);

            if (value < 0) {
                //Имитация сдвига влево, через сдвиг вправо (помним, что value тут отрицательное)
                realValue = arr.length + value;
            }

            int iNext;

            for (int n = 0; n < realValue; n++) { //Сдвигаем вправо нужное кол-во раз
                for (int i = (arr.length - 1); i > 0; i--) { //Сдвиг на одну ячейку вправо
                    iNext = Math.abs((i - 1)) % arr.length;
                    arr[i] ^= arr[iNext];
                    arr[iNext] ^= arr[i];
                    arr[i] ^= arr[iNext];
                }
            }
        }
    }

    public static boolean checkLeftAndRight (int [] arr) {
        if (arr != null && arr.length > 1) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int i = 1; i < arr.length; i++) { //i - индекс начала правой половины
                for (int j = 0; j < arr.length; j++) { //на каждый "i" прокручиваем весь массив
                    if (j < i) {
                        sumLeft += arr [j];
                    } else {
                        sumRight += arr [j];
                    }
                }
                if (sumLeft == sumRight) {
                    //System.out.println("Место разделения: " + i);
                    return true;
                }

                sumLeft = 0;
                sumRight = 0;
            }
        }
        return false;
    }

    public static int [] arrayCreateAndInit (int len, int initialValue) {
        if (len > 0) {
            int [] tempArr = new int [len];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr [i] = initialValue;
            }
            return tempArr;
        }

        return null; //Возвращаем null, если задана отрицательная или нулевая длина
    }
}
