package com.g16.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Savetool {
    // Things to save: Player names, money amount, round count, language used, maybe dice faces and amount,

    public static void ExportGame(Game.GameStructure gamedata) {
        //Gson gson = new Gson();
        try {
            File theDir = new File("savefiles\\");
            if (!theDir.exists()){
                theDir.mkdirs();    
            }
            Writer writer = new FileWriter("savefiles\\gamesave(" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ").json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(gamedata, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to save game");
        }
    }



    public static String[] getAllSaveFiles() {
        try {
            Stream<Path> walk = Files.walk(Paths.get("savefiles\\"), 1);

            List<Path> list = Arrays.asList(walk.toArray(Path[]::new));
            walk.close();
            List<String> toRet = new ArrayList<String>();
            
            for (int i = 1; i < list.size(); i++) {
                //System.out.println("ELEMENT: " + list.get(i).toString());
                String str = list.get(i).toString();
                Matcher m = Pattern.compile("savefiles\\\\gamesave(\\([0-9]{14}\\.txt\\)).json", 0).matcher(str);
                if (m.find()) {
                    str = m.group(1);
                }
                toRet.add(str);
            }
            return toRet.stream().toArray(String[]::new);
        } catch (Exception e) {
            System.out.println("ERROR IN GAME SAVE FILES");
            System.out.println(e.getMessage());
            return new String[0];
        }
    }

    public static void ImportGame(String filename) {
        try {
            Gson gson = new Gson();
            Game.GameStructure gs = gson.fromJson(new FileReader(filename), Game.GameStructure.class);
            Game.ImportData(gs);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR WHEN IMPORTING GAME");
            e.printStackTrace();
        }
    }

}
