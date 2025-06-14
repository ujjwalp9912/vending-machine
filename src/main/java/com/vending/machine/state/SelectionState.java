package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.coin.Coin;
import com.vending.machine.inventory.Item;

import java.util.List;

public class SelectionState extends MachineState {

    private List<Coin> coins;

    public SelectionState(List<Coin> coins) {
        this.coins = coins;
        System.out.println("Machine is in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) {
        Item item = vendingMachine.getInventory().getItem(productCode);

        int moneyPaidByUser = 0;
        for (Coin coin : coins) {
            moneyPaidByUser += coin.getValue();
        }

        int itemPrice = item.getPrice();
        if (itemPrice > moneyPaidByUser) {
            String message = "Insufficient amount, the price of product you selected is " + itemPrice + " and you paid " + moneyPaidByUser;
            refundAllCoins(vendingMachine);
            System.out.println(message);
        } else {
            if (moneyPaidByUser > itemPrice) {
                getChange(moneyPaidByUser - itemPrice);
            }
            vendingMachine.setMachineState(new DispenseState(vendingMachine, item));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) {
        System.out.println("Change of " + returnChangeMoney + " has been dispensed in the Coin dispense tray");
        return returnChangeMoney;
    }

    @Override
    public List<Coin> refundAllCoins(VendingMachine vendingMachine) {
        System.out.println("Refunded full money in the Coin dispense tray");
        vendingMachine.setMachineState(new IdleState());
        return coins;
    }
}
