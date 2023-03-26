package ru.croc.task6;

public class Main {
    public static void main(String[] args) {
        try {
            String[] sequence = {"g8","e7","c8"};
            System.out.println(String.join(", ",sequence));
            ChessPosition[] sequenceOfMove = new ChessPosition[sequence.length];
            parsePosition(sequence, sequenceOfMove);
            Knight knight = new Knight(sequenceOfMove);
            if (knight.canMoveAll(sequenceOfMove)){
                System.out.println("OK");
            }

        }catch (IllegalPositionException e){
            System.out.println(e.toString());
        }catch (IllegalMoveException e){
            System.out.println(e.toString());
        }
    }

    //метод, который записывает в массив все последовательности
    static void parsePosition(String[] sequence, ChessPosition[] sequenceOfMove ) throws IllegalPositionException {
        for (int i = 0; i < sequence.length; i++){
            sequenceOfMove[i] = ChessPosition.parse(sequence[i]);
        }
    }
}
