package ru.croc.task5;

public class Figure {
    protected String codeFigure;

    public Figure(){
        this.codeFigure = "F";
    }

    public String getCodeFigure() {
        return codeFigure;
    }

    public void setCodeFigure(String codeFigure) {
        this.codeFigure = codeFigure;
    }

    public boolean checkPoints(int x, int y){
        return false;
    }

    public void move(int dx, int dy){
        System.out.println("not moving");
    }

    //Вывод строкой
    @Override
    public String toString(){
        return codeFigure + " Empty figure box";
    }
}
