package com.g16.game;

interface player{
    public int setAccount();
    public String setName();
}

class Player implements player{
    public String name;
    public int account;
    public Player(){
        this.name = name;
        this.account = account;
    }
    public String setName(){
        return this.name;
    }
    public int setAccount(){
        return this.account;
    }
}
