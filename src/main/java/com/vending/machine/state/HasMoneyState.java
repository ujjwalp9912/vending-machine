package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.coin.Coin;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState extends MachineState {

    private List<Coin> coins;

    public HasMoneyState() {
        System.out.println("Machine is in HasMoneyState");
        this.coins = new ArrayList<>();
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Rs." + coin.getValue() + " coin inserted");
        this.coins.add(coin);
        vendingMachine.getCoinCount().put(coin, vendingMachine.getCoinCount().getOrDefault(coin, 0) + 1);
    }

    @Override
    public void clickOnProductSelectionButton(VendingMachine vendingMachine) {
        vendingMachine.setMachineState(new SelectionState(coins));
    }

    @Override
    public List<Coin> refundAllCoins(VendingMachine vendingMachine) {
        System.out.println("Refunded all the inserted coins in Coin dispense tray");
        vendingMachine.setMachineState(new IdleState());
        return this.coins;
    }

}
