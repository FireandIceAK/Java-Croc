package ru.croc.task4;

public class Circle extends Figure{
    //Вводим координаты центра и радиус
    private int x;
    private int y;
    private int r;

    public Circle(){
        this.x = 0;
        this.y = 0;
        this.r = 0;
        this.codeFigure = "C";
    }

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.codeFigure = "C";
    }


    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getR(){
        return r;
    }

    public void setR(int r){
        this.r = r;
    }

    //Вывод строкой
    @Override
    public String toString(){
        return codeFigure + " (" + x + ", " + y + "), " + r + ":";
    }
}
