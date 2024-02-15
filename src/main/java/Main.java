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
            File f = new File(name);
            try {
                boolean result = f.mkdir();
                if (result) {
                    log.append("Создана папка: " + f.getName() + "\n");
                } else {
                    log.append("Ошибка создания папки: " + f.getName() + "\n");
                }
            } catch (Exception e) {
            }
        }

        List<String> file = new ArrayList<>();
        file.add("Games/src/main/Main.java");
        file.add("Games/src/main/Utils.java");

        for (String name: file) {
            File f = new File(name);
            try {
                boolean result = f.createNewFile();
                if (result) {
                    log.append("Создан файл: " + f.getName() + "\n");
                } else {
                    log.append("Создан файл: " + f.getName() + "\n");
                }
            } catch (Exception e) {
            }
        }

        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
