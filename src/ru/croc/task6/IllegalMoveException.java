package ru.croc.task6;

public class IllegalMoveException extends Exception{
    private ChessPosition p1;
    private ChessPosition p2;


    public IllegalMoveException(ChessPosition p1, ChessPosition p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public ChessPosition getP1() {
        return p1;
    }

    public void setP1(ChessPosition p1) {
        this.p1 = p1;
    }

    public ChessPosition getP2() {
        return p2;
    }

    public void setP2(ChessPosition p2) {
        this.p2 = p2;
    }

    @Override
    public String toString(){
        return "конь так не ходит: " + p1 + " -> " + p2;
    }
}
