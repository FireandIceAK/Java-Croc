package ru.croc.task1;

import java.util.Scanner;

public class Main {
    //Создаём класс точки с координатами
    static class Point {
        double x;
        double y;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты точек:");
        //Вводим координаты точки a
        Point a = new Point();
        System.out.print("x1=");a.x = in.nextDouble();
        System.out.print("y1=");a.y = in.nextDouble();
        //Вводим координаты точки b
        Point b = new Point();
        System.out.print("x2=");b.x = in.nextDouble();
        System.out.print("y2=");b.y = in.nextDouble();
        //Вводим координаты точки c
        Point c = new Point();
        System.out.print("x3=");c.x = in.nextDouble();
        System.out.print("y3=");c.y = in.nextDouble();
        //Находим площадь треугольника
        double s = 0.5*(a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.y*(a.y-b.y));
        System.out.println("Площадь треугольника: " + s);
    }
}