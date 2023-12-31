package ru.geekbrains;

import java.util.Random;


public abstract class MyArray {
    //region Public Methods
    public MyArray(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.array = new String[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                this.array[y][x] = "0";
            }
        }
    }

    public MyArray(String[][] array, int sizeX, int sizeY) {
        this.array = array;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /**
     * Сделать массив рандомным.
     * @param sizeX
     * @param sizeY
     */
    public void makeRandom(int sizeX, int sizeY) {
        String[][] nullArray = new String[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                nullArray[y][x] = symbols[random.nextInt(symbols.length)];
            }
        }
        this.array = nullArray;
    }

    /**
     * Печать массива в консоль
     */
    public static void printArray() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                System.out.print("|");
                System.out.print(array[y][x] + "|");
            }
            System.out.println();
        }
    }

    //endregion

    //region Getters and Setters
    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public String[][] getArray() {
        return array;
    }
    //endregion

    //region Static Fields
    protected static String[] symbols = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "f", "g", "k", "m", "n", "p"};
    protected static Random random = new Random();
    protected static int sizeX;
    protected static int sizeY;
    protected static String[][] array;
    //endregion

    //region Fields

    //endregion

    /**
     * @return Пустой абстрактный метод
     */
    public abstract int size();

}




