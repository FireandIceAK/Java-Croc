package ru.croc.task8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java WordCount <filename>");
            return;
        }

        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        }

        System.out.println("Слов в тексте: " + wordCount);
    }

        /*String fileName = "input.txt";
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Слов найдено в " + fileName + ": " + wordCount);*/
}
