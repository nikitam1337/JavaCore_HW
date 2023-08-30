package ru.geekbrains.sample;

import ru.geekbrains.regular.Decorator;
import ru.geekbrains.regular.OtherClass;

/**
 * javadoc -encoding utf8 -d docs -sourcepath ./java -cp ./out -subpackages ru
 */
public class Main {
    public static void main(String[] args) {
        int result = OtherClass.add(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(2, 3);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(2, 3);
        System.out.println(Decorator.decorate(result));
    }
}