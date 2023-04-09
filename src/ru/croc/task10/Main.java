package ru.croc.task10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // открываем файл для чтения
        try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
            List<Long> startTimes = new ArrayList<>();
            List<Long> endTimes = new ArrayList<>();
            String line;
            // считываем данные из файла
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                startTimes.add(Long.parseLong(parts[0]));
                endTimes.add(Long.parseLong(parts[1]));
            }
            int count = 0; // счетчик одновременных разговоров
            int maxCount = 0; // максимальное количество одновременных разговоров
            int i = 0; // указатель на массив времени начала разговоров
            int j = 0; // указатель на массив времени окончания разговоров
            while (i < startTimes.size() && j < endTimes.size()) {
                if (startTimes.get(i) < endTimes.get(j)) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    i++;
                } else {
                    count--;
                    j++;
                }
            }
            System.out.println("Максимальное количество одновременных разговоров: " + (maxCount - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}