package ru.geekbrains;

public class MyIdealArray extends MyArray {

    /**
     * Создание идеального массива
     */
    public MyIdealArray() {
        super(idealArray,4,4);
    }

    /**
     * Поле с идеальным массивом для задачи
     */
    public static String[][] idealArray = {{"5", "7", "3", "4" },
            {"7", "5", "1", "9" },
            {"8", "1", "2", "3" },
            {"6", "1", "5", "8" }};

    @Override
    public int size() {
        return 0;
    }


}
