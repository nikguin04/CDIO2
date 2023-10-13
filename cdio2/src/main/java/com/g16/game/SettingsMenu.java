package com.g16.game;
import java.util.Scanner;

public class SettingsMenu {
    private static Scanner scanner;
    private static Player[] players;
    private static Game game;

    public static void SettingsPrompt(Scanner _scanner, Player[] _players, LanguagePack lang) {
        scanner = _scanner;
        players = _players;

        System.out.println(lang.getString("s_prompt_changeLanguageQuestion"));
        if (AwaitYesNo()) {
            PromptLanguage();
        }
    }

    private static void PromptLanguage() {
        System.out.println("Asking for language!!!");
        String[] packs = LanguagePack.getAllPacks();
    }
    private static void PromptNames() {

    }
    
    private static boolean AwaitYesNo() {
        while (true) {
            String decision = scanner.nextLine();
            if (decision.length() == 1) { // we only want to catch y or n, single characters
                if (decision.equals("y") || decision.equals("Y")) {
                    return true;
                } else if (decision.equals("n") || decision.equals("N")) {
                    return false;
                }
            }
        }
    }
}
