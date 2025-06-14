package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.inventory.Item;

public class DispenseState extends MachineState {

    public DispenseState(VendingMachine vendingMachine, int productCode, Item item) {
        System.out.println("Machine is in DispenseState");
        dispenseProduct(vendingMachine, productCode, item);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber, Item item) {
        System.out.println("Product has been dispensed");
        vendingMachine.getInventory().updateSoldItem(codeNumber);
        vendingMachine.setMachineState(new IdleState());
        return item;
    }
}
