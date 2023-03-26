package ru.croc.task6;



public class Knight {
    private ChessPosition[] sequenceOfMoves;

    public Knight(ChessPosition[] sequenceOfMoves){
        this.sequenceOfMoves = sequenceOfMoves;
    }

    //Создаём метод canMove, в котором идёт проврека сможет ли конь двигаться коректно
    //Конь меняет свою позицую только на 2 по x и на 1 по y или наоборот
    public static boolean canMove(ChessPosition p1, ChessPosition p2) throws IllegalMoveException{
        boolean test = (((Math.abs(p1.getX() - p2.getX()) == 2) && (Math.abs(p1.getY() - p2.getY()) == 1))
                || ((Math.abs(p1.getX() - p2.getX()) == 1) && (Math.abs(p1.getY() - p2.getY()) == 2)));
        if (!test){
            throw new IllegalMoveException(p1,p2);
        }
        else {
            return true;
        }
    }

    public boolean canMoveAll(ChessPosition[] sequenceOfMoves) throws IllegalMoveException{
        for (int i = 0; i < (sequenceOfMoves.length - 1); i++){
            canMove(sequenceOfMoves[i], sequenceOfMoves[i + 1]);
        }
        return true;
    }

    public ChessPosition[] getSequenceOfMoves() {
        return sequenceOfMoves;
    }

    public void setSequenceOfMoves(ChessPosition[] sequenceOfMoves) {
        this.sequenceOfMoves = sequenceOfMoves;
    }
}
