import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Task_1 {
    public static String[] sentencesGet(String filename) {
        try {
            String content = Files.readString(Path.of(filename));
            return content.split("(?<=[.!?])\\s+");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return new String[0];
        }
    }

    public static void main(String[] args) {
        String[] sentences = sentencesGet("text.txt");
        System.out.println(Arrays.toString(sentences));
//        for (String sentence : sentences) {
//            System.out.println(sentence);
//        }
    }
}
