package ru.geekbrains;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Program {
    
    public static void main(String[] args) throws IOException {
        String sourceDirectory = "./";
        String backupDirectory = "./backup";

        backup(sourceDirectory, backupDirectory);
    }

    public static void backup(String sourceDirectory, String backupDirectory) throws IOException {

        // Получаем список файлов в текушей директории
        File sourceDir = new File(sourceDirectory);
        File[] filesToBackup = sourceDir.listFiles();

        // Создаем папку для резервных копий, если ее нет
        File backupDir = new File(backupDirectory);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Проходим по всем файлам в текущей директории.
        for (File file : filesToBackup) {
            if (file.getName().equalsIgnoreCase("backup")) continue;

            // Если файл - это папка - запускаем метод backup для неё и углубляемся.
            if (file.isDirectory()) {
                backup(file.getAbsolutePath(), ((backupDirectory + "/" + file.getName()).toString()));
            }
            // Если текущий файл не папка, то мы его копируем в нашу папку backup с аналогичным вложением подпапок.
            else {
                Files.copy(file.toPath(), new File(backupDirectory + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
