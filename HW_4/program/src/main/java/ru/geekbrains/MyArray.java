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


    /**
     * Создает новый массив
     *
     * @param sizeX размер по горизонтали
     * @param sizeY размер по вертикали
     */
//    public MyArray(int sizeX, int sizeY) {
//        this.sizeX = sizeX;
//        this.sizeY = sizeY;
//
//    }
    public MyArray(String[][] array,int sizeX, int sizeY) {
        this.array = array;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
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

    /**
     * @return
     */
    public abstract int size();

}
