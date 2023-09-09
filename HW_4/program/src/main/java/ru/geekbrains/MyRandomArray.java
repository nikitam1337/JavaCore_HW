package ru.geekbrains;
import java.util.Random;
public class MyRandomArray extends MyArray {

    private static Random random = new Random();
    private static int sizeX;
    private static int sizeY;

    /**
     * Создает новый массив
     *
     * @param array Передаваемый двумерный массив строк
     * @param sizeX размер по горизонтали
     * @param sizeY размер по вертикали
     */
    public MyRandomArray() {
        super(array, sizeX, sizeY);
    }

    @Override
    public int size() {
        return 0;
    }

    int sizeX = random.nextInt(2,6);
    int sizeY = random.nextInt(2,6);
}
