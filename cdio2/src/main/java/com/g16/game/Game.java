package com.g16.game;
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        InitializeGame();
    }
    private static LanguagePack languagePack;
    private static Scanner scanner;
    private static Player[] players;
    public static void InitializeGame() {
        scanner = new Scanner(System.in);

        // Initialize players with default names, prompt for name in settings later
        players = new Player[] {new Player("Player 1"), new Player("Player 2")};

        // Initialize language pack as english, this can be changed later!
        languagePack = new LanguagePack("English");

        // Prompt player for settings (name and language change)
        SettingsMenu.SettingsPrompt(scanner, players, languagePack);

    }

    public void StartGame() {

    }

    public void PlayRound() {
        languagePack.getString("square_2");
    }

    private boolean CheckWinCondition(Player player) {
        return player.account.GetMoney() >= 3000;
    }

    public static void SetLanguage(String langFileName) {
        languagePack = new LanguagePack(langFileName);
    }
}
