package com.g16.game;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingsMenu {
    private static Scanner scanner;
    private static Player[] players;
    private static LanguagePack langPack;

    public static void SettingsPrompt(Scanner _scanner, Player[] _players, LanguagePack lang) {
        scanner = _scanner;
        players = _players;
        langPack = lang;

        System.out.println(langPack.getString("s_prompt_changeLanguageQuestion"));
        if (AwaitYesNo()) {
            PromptLanguage();
        }
        System.out.println(langPack.getString("s_prompt_changePlayerNameQuestion"));
        if (AwaitYesNo()) {
            PromptNames();
        }
    }

    private static void PromptLanguage() {

        String[] packs = LanguagePack.getAllPacks();
        if (packs.length > 0) {
            String langOutputString = "";
            for (int i = 0; i < packs.length; i++) {
                langOutputString += String.format("%s [%d], ", packs[i], i);
            }
            langOutputString = langOutputString.substring(0, langOutputString.length() - 2); // Cut off last comma and space
            System.out.println(String.format(langPack.getString("s_prompt_printLanguages"), langOutputString));
            
            int intChosen = -1;
            while (intChosen == -1) { // Await input and make sure it is in range
                String chosen = AwaitGroup("^([0-9]*)$");
                int tempConv = Integer.parseInt(chosen);
                if (tempConv >= 0 && tempConv < packs.length) {
                    intChosen = tempConv;
                }
            }
            System.out.println(String.format(langPack.getString("s_prompt_settingLanguageTo"), packs[intChosen]));
            Game.SetLanguage(packs[intChosen]);
            langPack = new LanguagePack(packs[intChosen]); // temp set to new language
        }
    }
    private static void PromptNames() {
        for (int i = 0; i < players.length; i++) {
            System.out.println(String.format(langPack.getString("s_prompt_changePlayerNameInputPrompt"), i+1));
            String newName = scanner.nextLine();
            Player player = players[i];
            player.SetName(newName);
        }
        System.out.println(langPack.getString("s_prompt_changePlayerNameSuccess"));
    }

    private static String AwaitGroup(String regex) {
        while (true) {
            String inpStr = scanner.nextLine();
            Matcher m = Pattern.compile(regex, 0).matcher(inpStr);
                if (inpStr != "" && m.find()) {
                    return m.group(1);
                }
        }
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
