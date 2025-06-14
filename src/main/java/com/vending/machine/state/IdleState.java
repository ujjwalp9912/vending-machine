package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.inventory.Item;

public class IdleState extends MachineState {

    public IdleState() {
        System.out.println("Machine is in IdleState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        vendingMachine.setMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
