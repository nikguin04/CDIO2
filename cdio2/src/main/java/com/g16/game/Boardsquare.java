package com.g16.game;
public class BoardSquare{
    public int moneyEffect;
    public String squareName;
    public String squareText;
    public boolean extraTurn;
    public BoardSquare(String squareName, int moneyEffect, String squareText, boolean extraTurn){
        this.squareName=squareName;
        this.moneyEffect=moneyEffect;
        this.extraTurn=extraTurn;
        this.squareText=squareText;
    }
    public String getSquareName(){
        return this.squareName;
    }
    public int getMoneyEffect(){
        return this.moneyEffect;
    }
    public boolean getExtraTurn(){
        return false;
    }
    public final static BoardSquare Tower = new BoardSquare("Tower", 250, "square_2", false);
            
    public final static BoardSquare Crater = new BoardSquare("Crater", -100, "square_3", false);

    public final static BoardSquare Palacegates = new BoardSquare("Palace Gates", 100, "square_4", false);

    public final static BoardSquare ColdDesert = new BoardSquare("Cold Desert", -20, "square_5", false);

    public final static BoardSquare WalledCity = new BoardSquare("Walled City", 180, "square_6", false);

    public final static BoardSquare Monestary = new BoardSquare("Monestary", 0, "square_7", false);

    public final static BoardSquare BlackCave = new BoardSquare("Black Cave", -70, "square_8", false);

    public final static BoardSquare HutsInTheMountain = new BoardSquare("Huts in the Mountain", 60, "square_9", false);

    public final static BoardSquare TheWereWall = new BoardSquare("The Were Wall", -80, "square_10", true);

    public final static BoardSquare ThePit = new BoardSquare("The Pit", -50, "square_11", false);

    public final static BoardSquare TheGoldMine = new BoardSquare("The Gold Mine", 650, "square_12", false);
}