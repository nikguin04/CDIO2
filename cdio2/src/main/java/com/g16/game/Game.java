package com.g16.game;
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        InitializeGame();
    }

    public static void InitializeGame() {
        Scanner scanner = new Scanner(System.in);

        // CLASS TO BE IMPLEMENTED LATER:
        Player[] players = {new Player("Player 1"), new Player("Player 2")};

        // Initialize language pack as english, this can be changed later!
        LanguagePack languagePack = new LanguagePack("English");
        SettingsMenu.SettingsPrompt(scanner, players, languagePack);

    }

    public void StartGame() {

    }

    public void PlayRound() {

    }

    /*private boolean CheckWinCondition(Player player) { // Player class not yet implemented!

    }*/

    public static void SetLanguage(String langFileName) {

    }
}
