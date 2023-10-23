package com.g16.game;

public class Account{
    private int Money;
    private int GetMoney() {
        return Money;
    }
    public void ModifyMoney(int _money) {
        Money += _money;
    }

    public Account(int startMoney) {
        Money = startMoney;
    }
}