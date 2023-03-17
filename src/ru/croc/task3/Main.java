package ru.croc.task3;
import java.util.Scanner;

public class Main {

    public static void sortMinMax(int[] a){
        //Поиск индекса максимального числа
        int MaxI=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[MaxI]){
                MaxI=i;
            }
        }
        //Поиск индекса минимального числа
        int MinI=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[MinI]){
                MinI=i;
            }
        }
        // Перестановка элементов
        int temp=a[0];
        a[0]=a[MinI];
        a[MinI]=temp;

        temp=a[a.length-1];
        a[a.length-1]=a[MaxI];
        a[MaxI]=temp;
    }


    public static void main (String[] args) {
        //Ввод чисел в массив
        Scanner in = new Scanner(System.in);
        int V=in.nextInt();System.out.println("Длина массива: "+ V);
        int x[]= new int[V];
        for (int i = 0; i < x.length; i++) {
            x[i]=in.nextInt();
        }

        //Вывод массива по заданию
        sortMinMax(x);
        for (int j = 0; j < x.length; j++) {
            System.out.print(x[j]+" ");
        }
    }
}

