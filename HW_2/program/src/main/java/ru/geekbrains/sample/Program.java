package ru.geekbrains.sample;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX;// Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static int maxFieldSizeX; // Максимальный размер игорового поля по оси X - задан изначально

    private static int maxFieldSizeY; // Максимальный размер игорового поля по оси Y - задан изначально

    private static  int winCount ; // Выигрышная комбинация

    public static void main(String[] args) {
        field = new char[3][3];
        maxFieldSizeX = 9; // - Тут можно изменить предельный размер игрового поля перед Запуском программы!
        maxFieldSizeY = 9;

        while (true) {
            initialize(maxFieldSizeX, maxFieldSizeY);
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize(int maxFieldSizeX, int maxFieldSizeY) {
        System.out.println("Игра Крестики-Нолики");
        int xSize = maxFieldSizeX; // x - горизонтальная ось
        int ySize = maxFieldSizeY; // y - вертикальная ось
        do {
            System.out.println("Задайте размер игрового поля.");
            while (true) {
                System.out.printf("Размер по вертикали: (от 3 до %s ): ", maxFieldSizeY); //(от 3 до maxFiledSizeY)
                if (scanner.hasNextInt()) {
                    ySize = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true) {
                System.out.printf("Размер по горизонтали: (от 3 до %s): ", maxFieldSizeX); //(от 3 до maxFiledSizeX)
                if (scanner.hasNextInt()) {
                    xSize = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isSizeValid(xSize, ySize));


        fieldSizeX = xSize;
        fieldSizeY = ySize;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }

        do {
            System.out.println("Задайте комбинацию для победы!");
            while (true) {
                System.out.printf("Количество в ряд для победы: (от 3 до %s ): ", Math.min(fieldSizeX,fieldSizeY));
                if (scanner.hasNextInt()) {
                    winCount = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isWinCountValid(winCount));
    }

    /**
     * Отрисовка игрового поля
     * <p>
     * +-1-2-3-
     * 1|*|X|0|
     * 2|*|*|0|
     * 3|*|*|0|
     * --------
     */
    private static void printField() {
        System.out.print("% ");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++) {
            System.out.print((x % 2 == 0) ? "|" : x / 2 + 1);
        }
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            if (y < 9) {
                System.out.print(y + 1 + " |");
            } else {
                System.out.print(y + 1 + "|");
            }
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;

        do {

            while (true) {
                System.out.printf("Введите координату хода X (от 1 до %s): ", fieldSizeX);
                if (scanner.hasNextInt()) {
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true) {
                System.out.printf("Введите координату хода Y (от 1 до %s): ", fieldSizeY);
                if (scanner.hasNextInt()) {
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка корректности ввода максимального размера поля
     * (Размеры по осям не должны превышать максимальную размерность игрового поля заданную программно)
     *
     * @param x горизонтальная ось
     * @param y вертикальная ось
     * @return
     */
    private static boolean isSizeValid(int x, int y) {
        return x >= 3 && x <= maxFieldSizeX && y >= 3 && y <= maxFieldSizeY;
    }

    /**
     * Проверка корректности ввода выигрышной комбинации
     * (Число не должно быть больше размера поля по оси)
     *
     * @param c
     * @return
     */
    private static boolean isWinCountValid(int c) {
        return c >= 3 && c < fieldSizeX && c < fieldSizeY;
    }


    /**
     * Обработка хода компьютера
     */
    private static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     *
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     *
     * @param c
     * @return
     */
    private static boolean checkWin(char c) { // TODO Разработать свой метод проверки на победу

        // Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private static boolean checkWinV2(char c) {


        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {

            }
        }

        return false;
    }

    static boolean check1(int x, int y, int win) {
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
