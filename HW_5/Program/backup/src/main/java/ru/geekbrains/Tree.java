package ru.geekbrains;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * @param file папка, которую необходимо распечатать в виде дерева
     * @param indent    отступ
     * @param isLast    Конечный ли файл (директория)
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int subFilesTotal = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            if (files[i].isFile())
                subFilesTotal++;
        }

        int subDirCounter = 0;
        int subFilesCounter = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal);
            }

            if (files[i].isFile()) {
                subFilesCounter++;
                print(files[i], indent, subFilesCounter==subFilesTotal );
            }
        }
    }

}
