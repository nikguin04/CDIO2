package com.g16.game;
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        InitializeGame(false);
    }
    private static LanguagePack languagePack;
    private static Scanner scanner;
    private static Player[] players;
    private static int roundCount = 0;
    private static int turn = 0;
    public static void InitializeGame(boolean testMode) {
        if (!testMode)
            scanner = new Scanner(System.in);

        // Initialize players with default names, prompt for name in settings later
        if (!testMode)
            players = new Player[] {new Player("Player 1"), new Player("Player 2")};
        else // game is automatically done on first run
            players= new Player[] {new Player("Player 1",4000), new Player("Player 2",4000)};

        // Initialize language pack as english, this can be changed later!
        languagePack = new LanguagePack("English");
 
        // Prompt player for settings (name and language change)
        if (!testMode)
            SettingsMenu.SettingsPrompt(scanner, players, languagePack);

        // Now we can start the game loop
        StartGame();

    }

    public static void StartGame() {
        boolean playerWon = false;
        Dice dice = new Dice(2, 6);
        while (!playerWon) { // Play until player has won
            for (;turn < 2; turn++) { // make this to an int for loop
                Player player = players[turn];
                Dice.DiceThrow dicethrow = dice.DiceThrow();
                System.out.println(String.format(languagePack.getString("dicerollresult"), dicethrow.individualResults[0], dicethrow.individualResults[1], dicethrow.addedResult));

                BoardSquare landedSquare = board.getSquare(dicethrow.addedResult);
                System.out.println(String.format(languagePack.getString(landedSquare.squareText), landedSquare.moneyEffect));
                player.account.ModifyMoney(landedSquare.moneyEffect);
                System.out.println(player.GetName() + ": " + player.account.GetMoney() + " " + languagePack.getString("money")); // temp text. use lang pack
                

                // End of turn, check if player has won and game is over
                if (CheckWinCondition(player)) {
                    System.out.println(player.GetName() + " " + languagePack.getString("haswon")); // temp text. use lang pack
                    playerWon = true;
                    break;
                }
                System.out.println(String.format(languagePack.getString("game_turn"), players[(turn+1)%2].GetName())); 
                HandleMidgameInput(scanner.nextLine()); // wait enter to continue next round
            }
            turn = 0;
            roundCount++;
        }
    }


    public static void HandleMidgameInput(String line) {
        if (line.equals("savegame")) {
            System.out.println(languagePack.getString("savegame"));
            Savetool.ExportGame(ExportData());
            System.exit(0);
        }
    }

    /*public static void PlayRound() {
        languagePack.getString("square_2");
    }*/

    private static boolean CheckWinCondition(Player player) {
        return player.account.GetMoney() >= 3000;
    }

    public static void SetLanguage(String langFileName) {
        languagePack = new LanguagePack(langFileName);
    }

    public static class GameStructure {
        public String language;
        public String[] playerNames;
        public int[] moneyAmount;
        public int roundCount;
        public int turn = 0;
    }
    public static GameStructure ExportData() {
        GameStructure gs = new GameStructure();
        gs.language = languagePack.getName();
        gs.playerNames = new String[] {players[0].GetName(), players[1].GetName()};
        gs.moneyAmount = new int[] {players[0].account.GetMoney(), players[1].account.GetMoney()};
        gs.roundCount = roundCount;
        gs.turn = (turn + 1) % 2; // turn is not yet plussed by one, so do it manually
        return gs;
    }
    public static void ImportData(GameStructure gamedata) {
        SetLanguage(gamedata.language);
        Player p1 = new Player(gamedata.playerNames[0], gamedata.moneyAmount[0]);
        Player p2 = new Player(gamedata.playerNames[1], gamedata.moneyAmount[1]);
        players = new Player[] {p1, p2};
        roundCount = gamedata.roundCount;
        turn = gamedata.turn;
    }
}
