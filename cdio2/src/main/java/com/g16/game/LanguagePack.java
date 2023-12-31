package com.g16.game;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.net.URI;
import java.net.URL;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.google.gson.Gson;

public class LanguagePack {
    private String name;
    //private Dictionary dictionary;
    private Map<String, String> dictionary;

    public LanguagePack(String packName) {
        try {
            Gson gson = new Gson();

            try {
                LanguagePack object = gson.fromJson(new FileReader("LanguageContainer\\" + packName + ".json"), LanguagePack.class);
                this.name = object.name;
                this.dictionary = object.dictionary;
            } catch (IOException e) {
                System.out.println("An error occurred while reading language pack!");
                e.printStackTrace();
            }
        } catch ( Exception e) {
            System.out.println("An error occurred while opening language pack!");
            e.printStackTrace();
        }
    }
    

    public String getString(String index) {
        try {
            return dictionary.get(index).toString();
        } catch (Exception e) {
            System.out.println("An error occurred while reading language string!");
            e.printStackTrace();
            return "MISSING: " + index; // return original string input with missing prefix
        }
    }
    public String getName() {
        return name;
    }
    public String[] getIndexes() {
        return dictionary.keySet().toArray(String[]::new);
    }

    public static String[] getAllPacks() {
        try {
            Stream<Path> walk = Files.walk(Paths.get("LanguageContainer\\"), 1);
            

            List<Path> list = Arrays.asList(walk.toArray(Path[]::new));
            walk.close();
            List<String> toRet = new ArrayList<String>();

            for (int i = 1; i < list.size(); i++) {
                //System.out.println("ELEMENT: " + list.get(i).toString());
                String str = list.get(i).toString();
                Matcher m = Pattern.compile("\\\\([a-zA-Z0-9]*?).json", 0).matcher(str);
                if (m.find()) {
                    str = m.group(1);
                }
                toRet.add(str);
            }
            return toRet.stream().toArray(String[]::new);
        } catch (Exception e) {
            System.out.println("FATAL ERROR IN LANGUAGE RESOURCES");
            System.out.println(e.getMessage());
            return new String[0];
        }
        //InputStream inputStream = classLoader.getResourceAsStream("LanguageContainer/" + packName + ".json");
       
    }
}
