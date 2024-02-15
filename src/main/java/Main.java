package src.main.java.*

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        createFolder(new File("Games"));
        createFolder(new File("Games/src"));
        createFolder(new File("Games/res"));
        createFolder(new File("Games/savegames"));
        createFolder(new File("Games/temp"));

        createFolder(new File("Games/src/main"));
        createFolder(new File("Games/src/test"));

        createFile(new File("Games/src/main/Main.java"));
        createFile(new File("Games/src/main/Utils.java"));

        createFolder(new File("Games/res/drawables"));
        createFolder(new File("Games/res/vectors"));
        createFolder(new File("Games/res/icons"));

        createFile(new File("Games/temp/temp.txt"));

        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                addLog("Создан файл: " + file.getName());
                return;
            }

        } catch (Exception e) {}

        addLog("Ошибка создания файла: " + file.getName());
    }

    private static void createFolder(File folder) {
        if(folder.mkdir()) {
            addLog("Создана папка: " + folder.getName());
            return;
        }

        addLog("Ошибка создания папки: " + folder.getName());
    }

    private static void addLog(String text) {
        log.append(text);
        log.append("\n");
    }
}
