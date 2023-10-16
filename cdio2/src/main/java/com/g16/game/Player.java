package com.g16.game;

interface player{
    public int Account;
    public String name;
    public String setName():
}

public class Player {
    private String name;
    public Player (String _name) {
        name = _name;
    }


    public String GetName() {
        return name;
    }
    public void SetName(String _name) {
        name = _name;
    }
}
