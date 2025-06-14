package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.inventory.Item;

public class DispenseState extends MachineState {

    public DispenseState(VendingMachine vendingMachine, int productCode) {
        System.out.println("Machine is in DispenseState");
        dispenseProduct(vendingMachine, productCode);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int productCode) {
        Item item = vendingMachine.getInventory().getItem(productCode);
        System.out.println("Product has been dispensed");
        vendingMachine.setMachineState(new IdleState());
        return item;
    }
}
