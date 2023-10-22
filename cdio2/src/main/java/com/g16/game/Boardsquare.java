package com.g16.game;
interface Board{
    public String getSquareName();
    public int getMoneyEffect();
    public String getSquareText();
    public boolean getExtraTrun();

}
class Tower implements Board{
    String squareName="Tower";
    int moneyEffect=250;
    String squareText="Du dræber en drage i tårnet, og tager dens guld. +250 guld!";
    int squareNumber=1;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class Crater implements Board{
    String squareName="Crater";
    int moneyEffect=-100;
    String squareText="Øv bøv, du har knækket dit lårben og vi tager 100 guld. -100 guld!";
    int squareNumber=2;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class Palacegates implements Board{
    String squareName="Palacegates";
    int moneyEffect=100;
    String squareText="Du er nået palasset du får 100 guld!";
    int squareNumber=3;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class ColdDesert implements Board{
    String squareName="ColdDesert";
    int moneyEffect=-20;
    String squareText="Øv bøv -20 guld";
    int squareNumber=4;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class WalledCity implements Board{
    String squareName="WalledCity";
    int moneyEffect=180;
    String squareText="du grim makker, derfor får du 180 guld!";
    int squareNumber=5;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class Monestary implements Board{
    String squareName="Monestary";
    int moneyEffect=0;
    String squareText="Jaa fedt at være en munk. Du chiller for en tur.";
    int squareNumber=6;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class BlackCave implements Board{
    String squareName="Black Cave";
    int moneyEffect=-70;
    String squareText="Du er blevet røvet af en pirat -70 guld";
    int squareNumber=7;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}

}
class HutsInTheMountain implements Board{
    String squareName="Huts in the Mountain";
    int moneyEffect=60;
    String squareText="Du stjæler fra en bonde +60 guld";
    int squareNumber=8;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class TheWereWall implements Board{
    String squareName="The Were Wall!";
    int moneyEffect=-80;
    String squareText="Du er nået The Were Wall. Varulvene tager 80 guld, men du får et ekstra slag med terningerne";
    int squareNumber=9;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return true;
}
}
class ThePit implements Board{
    String squareName="The Pit";
    int moneyEffect=-50;
    String squareText="Hejsa. Du kan ikke komme op. Du stabler 50 guld og kravler op. -50 guld!";
    int squareNumber=11;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
class TheGoldMine implements Board{
    String squareName="The Gold Mine";
    int moneyEffect=650;
    String squareText="Sådan du er en rig makker +650 guld";
    int squareNumber=12;
    boolean extraTurn;
public String getSquareName(){
    return this.squareName;
}
public int getMoneyEffect(){
    return this.moneyEffect;
}
public String getSquareText(){
    return this.squareText;
}
public boolean getExtraTrun(){
    return false;
}
}
