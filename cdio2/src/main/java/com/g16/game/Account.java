package com.g16.game;

public class Account{
    private int Money;
    public int GetMoney() {
        return Money;
    }
    public void ModifyMoney(int _money) {
        Money += _money;
    }

    public Account(int startMoney) {
        Money = startMoney;
    }
}