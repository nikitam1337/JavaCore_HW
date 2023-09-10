package ru.geekbrains.MyExceptions;

public class MyException extends Exception {
    //
//    private final String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public MyException (String message, String name) {
//        super(message);
//        this.name = name;
//    }
    public MyException(String message) {
        super(message);

    }
}
