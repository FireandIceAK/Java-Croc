package ru.croc.task2;

import java.util.Scanner;

public class Main{
    //Создаю метод
    static void printByte(Float n){
        //Создаю конструкцию, которая преобразует заданный размер в байтах в человеческом виде
        if (n>0){
            if (n < 1024f){
                System.out.printf("%.1f B", n);
            }
            if (1024f <= n && n<1_048_576f){
                n=n/1024f;
                System.out.printf("%.1f KB", n);
            }
            if (1_048_576f <= n && n<1_073_741_824f){
                n=n/1_048_576f;
                System.out.printf("%.1f MB", n);
            }
            if (1_073_741_824f <= n && n<1_099_511_627_776f){
                n=n/1_073_741_824f;
                System.out.printf("%.1f GB", n);
            }
            if (1_099_511_627_776f <= n && n < 1_125_899_906_842_624f){
                n=n/1_099_511_627_776f;
                System.out.printf("%.1f TB", n);
            }
        }
    }

    public static void main(String[] args){
        float n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите колличество байтов: ");n = in.nextFloat();
        //Выводим метод
        printByte(n);
    }
}
