package ru.croc.task4;

public class Rectangle extends Figure{
    //координаты левого нижнего угла прямоугольника
    private int x1;
    private int y1;
    //координаты верхнего правого угла прямоугольника
    private int x2;
    private int y2;

    public Rectangle(){
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.codeFigure = "R";
    }

    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.codeFigure = "R";
    }

    public int getX1(){
        return x1;
    }
    public void setX1(int x1){
        this.x1 = x1;
    }

    public int getY1(){
        return y1;
    }

    public void setY1(int y1){
        this.y1 = y1;
    }

    public int getX2(){
        return x2;
    }

    public void setX2(int x2){
        this.x2 = x2;
    }

    public int getY2(){
        return y2;
    }

    public void setY2(int y2){
        this.y2 = y2;
    }
    //Вывод строкой
    @Override
    public String toString(){
        return codeFigure + " (" + x1 + ", " + y1 + ")," + " (" + x2 + ", " + y2 + "):";
    }
}
