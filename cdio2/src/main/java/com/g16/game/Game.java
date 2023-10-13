package com.g16.game;
import java.util.Scanner;

public class Game {
    
    public void main(String[] args) {
        InitializeGame();
    }

    public void InitializeGame() {
        Scanner scanner = new Scanner(System.in);

        // CLASS TO BE IMPLEMENTED LATER:
        //Player[] players = {new Player("Player 1"), new Player("Player 2")};

        // Initialize language pack as english, this can be changed later!
        LanguagePack languagePack = new LanguagePack("English.json");

    }
}
