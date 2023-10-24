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

        // Now we can start the game loop
        StartGame();

    }

    public static void StartGame() {
        boolean playerWon = false;
        Dice dice = new Dice(2, 6);
        while (!playerWon) { // Play until player has won
            for (Player player : players) { // make this to an int for loop
                Dice.DiceThrow dicethrow = dice.DiceThrow();

                BoardSquare landedSquare = board.getSquare(dicethrow.addedResult);
                System.out.println(String.format(languagePack.getString(landedSquare.squareText), landedSquare.moneyEffect));
                player.account.ModifyMoney(landedSquare.moneyEffect);
                System.out.println(player.GetName() + ": " + player.account.GetMoney() + " money"); // temp text. use lang pack
                

                // End of turn, check if player has won and game is over
                if (CheckWinCondition(player)) {
                    System.out.println(player.GetName() + " Has won"); // temp text. use lang pack
                    playerWon = true;
                    break;
                }
                scanner.nextLine(); // wait enter to continue next round
            }
        }
    }

    public static void PlayRound() {
        languagePack.getString("square_2");
    }

    private static boolean CheckWinCondition(Player player) {
        return player.account.GetMoney() >= 3000;
    }

    public static void SetLanguage(String langFileName) {
        languagePack = new LanguagePack(langFileName);
    }
}
