package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.coin.Coin;
import com.vending.machine.inventory.Item;

import java.util.List;

public abstract class MachineState {

    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        System.out.println("Invalid operation in this state");
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Invalid operation in this state");
    }

    public void clickOnProductSelectionButton(VendingMachine vendingMachine) {
        System.out.println("Invalid operation in this state");
    }

    public void chooseProduct(VendingMachine vendingMachine, int productCode) {
        System.out.println("Invalid operation in this state");
    }

    public int getChange(int returnChangeMoney) {
        System.out.println("Invalid operation in this state");
        return 0;
    }

    public Item dispenseProduct(VendingMachine vendingMachine, int productCode, Item item) {
        System.out.println("Invalid operation in this state");
        return null;
    }

    public List<Coin> refundAllCoins(VendingMachine vendingMachine) {
        System.out.println("Invalid operation in this state");
        return null;
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) {
        System.out.println("Invalid operation in this state");
    }
}
