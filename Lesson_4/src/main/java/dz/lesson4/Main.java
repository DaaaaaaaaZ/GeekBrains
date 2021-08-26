package dz.lesson4;

import java.util.Scanner;

public class Main {
    public static final int SIZE = 5; //Размер поля SIZE x SIZE
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final char DOT_EMPTY = '-';
    public static final int NEED_TO_WINS = 4; //Длина цепочки символов для победы
    public static char [][] map; //Игровое поле

    public static void main(String[] args) {
        initGameField ();
        Scanner scanner = new Scanner(System.in);
        int [] coords = new int [2]; //Координаты хода : 0 - по горизонтали, 1 - по вертикали от 1 до SIZE

        System.out.println("Добро пожаловать в консольную версию игры крестики-нолики. Вы играете крестиком.");

        printGameField ();
        while (true) { //Бесконечный цикл для игры
            if (isMoveAvaible ()) {
                receivePlayerMove(coords, scanner);
                map [coords [0] - 1][coords [1] - 1] = DOT_X;
                System.out.println("Ход сделан по координатам " + coords [0] + ", " + coords [1]);
                printGameField();
                if (checkForVictory(coords)) {
                    System.out.println("Вы только что выиграли!!!");
                    break;
                }
            } else {
                System.out.println("Победила ничья!!!");
                break;
            }

            if (isMoveAvaible()) {
                makeAIMove(coords);
                map [coords [0] - 1][coords [1] - 1] = DOT_0;
                System.out.println("ИИ сделал ход по координатам " + coords [0] + ", " + coords [1]);
                printGameField();
                if (checkForVictory(coords)) {
                    System.out.println("Вы проиграли!");
                    break;
                }
            } else {
                System.out.println("Победила ничья!!!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean isMoveAvaible() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map [x][y] == DOT_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    //Является ли последний ход победным
    private static boolean checkForVictory(int [] coords) {
        int coordX = coords [0] - 1;
        int coordY = coords [1] - 1;

        //Накопительная переменная для каждой проверки (для победы необходимо NEED_TO_WINS звена в цепи)
        int chain = 1;

        char curSymb = map [coordX][coordY]; //Символ в текущей ячейке
        int tempX = 0;
        int tempY = 0;

        //Проверка горизонтали
        for (int i = 1; i < SIZE; i++) { //В одну сторону
            tempX = coordX + i;
            //System.out.println("Индексы массива: <<" + tempX + ", " + coordY + ">>");
            if (tempX < SIZE && map [tempX][coordY] == curSymb) {
                chain++;
                //System.out.println("Chain = " + chain);
            } else {
                break;
            }
        }

        for (int i = 1; i < SIZE; i++) { //В другую сторону
            tempX = coordX - i;
            if (tempX >= 0 && map [tempX][coordY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        if (chain > (NEED_TO_WINS - 1)) {
            return true;
        }
        chain = 1;

        //Проверка вертикали
        for (int i = 1; i < SIZE; i++) { //В одну сторону
            tempY = coordY + i;
            if (tempY < SIZE && map [coordX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        for (int i = 1; i < SIZE; i++) { //В другую сторону
            tempY = coordY - i;
            if (tempY >= 0 && map [coordX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        if (chain > (NEED_TO_WINS - 1)) {
            return true;
        }
        chain = 1;

        //Проверка обратной диагонали
        for (int i = 1; i < SIZE; i++) { //В одну сторону
            tempX = coordX + i;
            tempY = coordY + i;
            if (tempX < SIZE && tempY < SIZE && map [tempX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        for (int i = 1; i < SIZE; i++) { //В другую сторону
            tempX = coordX - i;
            tempY = coordY - i;
            if (tempX >= 0 && tempY >= 0 && map [tempX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        if (chain > (NEED_TO_WINS - 1)) {
            return true;
        }
        chain = 1;

        //Проверка прямой диагонали
        for (int i = 1; i < SIZE; i++) { //В одну сторону
            tempX = coordX + i;
            tempY = coordY - i;
            if (tempX < SIZE && tempY >= 0 && map [tempX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        for (int i = 1; i < SIZE; i++) { //В другую сторону
            tempX = coordX - i;
            tempY = coordY + i;
            if (tempX >= 0 && tempY < SIZE && map [tempX][tempY] == curSymb) {
                chain++;
            } else {
                break;
            }
        }

        if (chain > (NEED_TO_WINS - 1)) {
            return true;
        }

        return false;
    }

    private static void makeAIMove(int [] coords) {
        while (true) {
            coords [0] = (int)(Math.random() * SIZE + 1);
            coords [1] = (int)(Math.random() * SIZE + 1);
            if (checkValidationMove(coords)) {
                return;
            }
        }
    }

    private static void printGameField() {
        System.out.print("* ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int y = 0; y < SIZE; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < SIZE; x++) {
                System.out.print(map [x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void receivePlayerMove(int [] coords, Scanner scanner) {
        while (true) {
            System.out.println("Введите координаты хода (от 1 до " + SIZE +
                    ") - сначала по горизонтали, затем по вертикали:");
            coords [0] = scanner.nextInt();
            coords [1] = scanner.nextInt();

            if (coords [0] < 1 || coords [0] > SIZE || coords [1] < 1 || coords [1] > SIZE) {
                continue;
            } else if (checkValidationMove (coords)) {
                return;
            } else {
                System.out.println("Ячейка с координатами " + coords [0] + ", " + coords [1] + " занята." +
                        "Для хода необходимо выбрать пустую ячейку.");
                continue;
            }
        }
    }

    private static boolean checkValidationMove(int[] coords) {
        int x = coords [0] - 1;
        int y = coords [1] - 1;

        if (map [x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    private static void initGameField() {
        map = new char [SIZE][SIZE];
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                map [x][y] = DOT_EMPTY;
            }
        }
    }


}
