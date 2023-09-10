package ru.geekbrains;

import java.util.ArrayList;
import java.util.Random;


public abstract class MyArray {

    protected static int sizeX;
    protected static int sizeY;

    protected static String[][] array;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public String[][] getArray() {
        return array;
    }

    public MyArray(String[][] array, int sizeX, int sizeY) {
        this.array = array;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public MyArray(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
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
     * @return Пустой абстрактный метод
     */
    public abstract int size();

    protected static String[] symbols = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "f", "g", "k", "m", "n", "p"};
    protected static Random random = new Random();

}




