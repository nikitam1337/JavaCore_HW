package ru.geekbrains;

public class Program {


    public static void main(String[] args) {

        MyIdealArray test1 = new MyIdealArray();
        test1.printArray();

        System.out.println();

        MyRandomArray test2 = new MyRandomArray();

        test2.printArray();

        System.out.println();

        test2.makeRandom(test1.getSizeX(), test2.getSizeY());

        test2.printArray();

    }

}