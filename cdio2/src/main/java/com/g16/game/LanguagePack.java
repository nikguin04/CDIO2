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
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
            //LanguagePack object = gson.fromJson(new FileReader("C:\\Users\\nikla\\Desktop\\Programmering\\mvn\\cdio2\\src\\main\\java\\com\\g16\\LanguageContainer\\" + packName), LanguagePack.class);

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("LanguageContainer/" + packName + ".json");
            try {
                String read = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                LanguagePack object = gson.fromJson(read, LanguagePack.class);
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
    public String[] getIndexes() {
        return dictionary.keySet().toArray(String[]::new);
    }

    public static String[] getAllPacks() {
        ClassLoader classLoader = LanguagePack.class.getClassLoader();
        try {
            String inResourcesPath = "/LanguageContainer";
            URI uri = LanguagePack.class.getResource(inResourcesPath).toURI();
            Stream<Path> walk = Files.walk(Path.of(uri), 1);

            List<Path> list = walk.toList();
            String[] toReturn = new String[list.size()-1];
            for (int i = 1; i < list.size(); i++) {
                //System.out.println("ELEMENT: " + list.get(i).toString());
                String str = list.get(i).toString();
                Matcher m = Pattern.compile("\\\\([a-zA-Z0-9]*?).json", 0).matcher(str);
                if (m.find()) {
                    str = m.group(1);
                }
                toReturn[i-1] = str;
                System.out.println("str: " + str);
            }



            return new String[0];
        } catch (Exception e) {
            System.out.println("FATAL ERROR IN LANGUAGE RESOURCES");
            System.out.println(e.getMessage());
            return new String[0];
        }
        //InputStream inputStream = classLoader.getResourceAsStream("LanguageContainer/" + packName + ".json");
       
    }
}
