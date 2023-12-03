package me.partlysunny.sunbeam.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class FileUtils {

    public static String read(File file) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] readLines(File file) {
        String readFile = read(file);
        if (readFile == null) {
            return null;
        }
        return readFile.split("\n");
    }

    public static String readCollapsed(File file) {
        String readFile = read(file);
        if (readFile == null) {
            return null;
        }
        return readFile.replaceAll("\n", "");
    }

    public static void write(File file, String content) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCollapsed(File file, String content) {
        write(file, content.replaceAll("\n", ""));
    }

}
