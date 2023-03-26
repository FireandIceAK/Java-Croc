package ru.croc.task6;

public class ChessPosition {
    private int x;
    private int y;


    public ChessPosition(int x, int y) throws IllegalPositionException{
        if ((x > 7 || x < 0) || (y > 7 || y < 0)){
            throw new IllegalPositionException(x,y);
        }else{
            this.x = x;
            this.y = y;
        }

    }

    //Фабричный метод
    static ChessPosition parse(String position) throws IllegalPositionException {
        int x = (position.charAt(0)-97);
        int y = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
        return new ChessPosition(x,y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws IllegalPositionException {
        if (x > 7 || x < 0) {
            throw new IllegalPositionException(x,y);
        }else {
            this.x = x;
        }
    }

    public int getY(){
        return y;
    }

    public void setY(int y) throws IllegalPositionException {
        if (y > 7 || y < 0) {
            throw new IllegalPositionException(x,y);
        }else {
            this.y = y;
        }
    }

    //к игрику прибававляю 1, т.к. отчёт с (0,0)
    //к иксу прибавляю 97, как в таблице ASCII
    @Override
    public String toString() {
        return "" + (char) (this.x + 97) + (this.y+1);
    }
}
