package com.g16.game;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
            InputStream inputStream = classLoader.getResourceAsStream("LanguageContainer/" + packName);
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
}
