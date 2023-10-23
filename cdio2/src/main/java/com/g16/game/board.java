package com.g16.game;

public class board {

    private static BoardSquare[] boardSquares = new BoardSquare[]{
        new BoardSquare("Tower", 250, "square_2", false),
        new BoardSquare("Crater", -100, "square_3", false),
        new BoardSquare("Palace Gates", 100, "square_4", false),
        new BoardSquare("Cold Desert", -20, "square_5", false),
        new BoardSquare("Walled City", 180, "square_6", false),
        new BoardSquare("Monestary", 0, "square_7", false),
        new BoardSquare("Black Cave", -70, "square_8", false),
        new BoardSquare("Huts in the Mountain", 60, "square_9", false),
        new BoardSquare("The Were Wall", -80, "square_10", true),
        new BoardSquare("The Pit", -50, "square_11", false),
        new BoardSquare("The Gold Mine", 650, "square_12", false),
    };

    public static BoardSquare getSquare(int squareNumber) {
        return board.boardSquares[squareNumber - 1];
    }

 
}