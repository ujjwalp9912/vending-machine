package com.vending.machine.coin;

public enum Coin {

    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private int value;

    Coin(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
