package ru.geekbrains.regular;
/**
 * Декоратор для декорации
 */
public class Decorator {
    public static String decorate (int a) {
        /**
         * Метод декорирует число, добывляя ему строку
         */
        return String.format("Here is your number: %d.", a);
    }
}