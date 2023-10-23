package com.g16.game;

public class Player {
    private String name;
    public Account account;
    public Player (String _name) {
        name = _name;
        account = new Account(1000);
    }


    public String GetName() {
        return name;
    }
    public void SetName(String _name) {
        name = _name;
    }
}
