package com.vending.machine.state;

import com.vending.machine.VendingMachine;
import com.vending.machine.inventory.Item;

public class DispenseState extends MachineState {

    public DispenseState(VendingMachine vendingMachine, Item item) {
        System.out.println("Machine is in DispenseState");
        dispenseProduct(vendingMachine, item);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, Item item) {
        System.out.println("Product has been dispensed");
        vendingMachine.setMachineState(new IdleState());
        return item;
    }
}
