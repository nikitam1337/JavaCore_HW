package ru.geekbrains;

import ru.geekbrains.MyExceptions.MyArrayDataException;
import ru.geekbrains.MyExceptions.MyArraySizeException;
import ru.geekbrains.MyExceptions.MyException;

public class Program {


    public static void main(String[] args) {

//        MyIdealArray test1 = new MyIdealArray();
//        test1.printArray();
//
//        System.out.println();
//
        MyRandomArray test2 = new MyRandomArray();
        test2.printArray();
        System.out.println();
        test2.makeRandom(test2.getSizeX(), test2.getSizeY());
        test2.printArray();
        try {
            int sum = summingArrayNumbers(test2);
            System.out.printf("Сумма значений в массиве = %d", sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int summingArrayNumbers(MyArray array) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (array.getSizeX() != 4 | array.getSizeY() != 4) {
            throw new MyArraySizeException("Размерность массива не равна 4х4");
        }
        int xCoordinate = 0;
        int yCoordinate = 0;
        try {
            for (int y = 0; y < array.getSizeY(); y++) {
                for (int x = 0; x < array.getSizeX(); x++) {
                    xCoordinate = x;
                    yCoordinate = y;
                    sum += Integer.parseInt(array.getArray()[y][x]);
                }
            }
        } catch (NumberFormatException e) {
            String message = String.format("Ошибка данных в ячейке: X=%d Y=%d", xCoordinate, yCoordinate);
            throw new MyArrayDataException(message);
        }
        return sum;
    }
}