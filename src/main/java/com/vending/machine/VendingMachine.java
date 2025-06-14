package com.vending.machine;

import com.vending.machine.coin.Coin;
import com.vending.machine.inventory.Inventory;
import com.vending.machine.state.IdleState;
import com.vending.machine.state.MachineState;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private MachineState machineState;
    private Inventory inventory;
    private Map<Coin, Integer> coinCount; // this can be used to return change

    public VendingMachine() {
        this.machineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinCount = new HashMap<>();
    }

    public void setMachineState(MachineState newState) {
        this.machineState = newState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public MachineState getMachineState() {
        return machineState;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Map<Coin, Integer> getCoinCount() {
        return coinCount;
    }
}
