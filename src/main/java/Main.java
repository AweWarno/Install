package src.main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();


    public static void main(String[] args) {
        List<String> folder = new ArrayList<>();
        folder.add("Games");
        folder.add("Games/src");
        folder.add("Games/res");
        folder.add("Games/savegames");
        folder.add("Games/temp");
        folder.add("Games/src/main");
        folder.add("Games/src/test");
        folder.add("Games/res/drawables");
        folder.add("Games/res/vectors");
        folder.add("Games/res/icons");

        for (String name : folder) {
            createDirectory(name);
        }

        List<String> file = new ArrayList<>();
        file.add("Games/src/main/Main.java");
        file.add("Games/src/main/Utils.java");

        for (String name : file) {
            createFile(name);
        }

        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean createDirectory(String name) {
        File file = new File(name);
        boolean result = false;
        try {
            result = file.mkdir();
            if (result) {
                log.append("Создана папка: " + file.getName() + "\n");
            } else {
                log.append("Ошибка создания папки: " + file.getName() + "\n");
            }
        } catch (Exception e) {
        }

        return result;
    }

    public static boolean createFile(String name) {
        File file = new File(name);
        boolean result = false;
        try {
            result = file.createNewFile();
            if (result) {
                log.append("Создан файл: " + file.getName() + "\n");
            } else {
                log.append("Создан файл: " + file.getName() + "\n");
            }
        } catch (Exception e) {
        }

        return result;
    }
}
