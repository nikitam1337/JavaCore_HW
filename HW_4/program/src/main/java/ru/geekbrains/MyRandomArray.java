package ru.geekbrains;
import java.util.Random;
public class MyRandomArray extends MyArray {

    private static Random random = new Random();
    private static int sizeY;

    private static String[][] randomArray;

    /**
     * Создает новый массив
     *
     * @param array Передаваемый двумерный массив строк
     * @param sizeX размер по горизонтали
     * @param sizeY размер по вертикали
     */
    public MyRandomArray() {
        super(random.nextInt(2,5),random.nextInt(2,5));
    }

    @Override
    public int size() {
        return 0;
    }

}
