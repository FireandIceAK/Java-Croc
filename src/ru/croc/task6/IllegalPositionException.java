package ru.croc.task6;

public class IllegalPositionException extends Exception {
    private int x;
    private int y;


    public IllegalPositionException(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "На шахматной доске нет такой клетки: " +  (char)(this.x + 97) + (this.y + 1);
    }
}
