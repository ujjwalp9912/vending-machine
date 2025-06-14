package com.vending.machine;

import com.vending.machine.coin.Coin;
import com.vending.machine.inventory.Item;
import com.vending.machine.inventory.ItemShelf;
import com.vending.machine.inventory.ItemType;
import com.vending.machine.state.MachineState;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("Inventory is getting filled up");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            MachineState state = vendingMachine.getMachineState(); // idle state
            System.out.println("Clicking on insert coin button");
            state.clickOnInsertCoinButton(vendingMachine);

            state = vendingMachine.getMachineState(); // Has money state
            state.insertCoin(vendingMachine, Coin.TEN);
            state.insertCoin(vendingMachine, Coin.TEN);

            System.out.println("Clicking on select product button");
            state.clickOnProductSelectionButton(vendingMachine);

            state = vendingMachine.getMachineState(); // selection state
            state.chooseProduct(vendingMachine, 105);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            displayInventory(vendingMachine);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        System.out.println();
        for (ItemShelf slot : slots) {
            Item item = slot.getItem();
            String itemName = null == item ? "Vacant" : item.getItemType().name();
            int itemPrice = null == item ? 0 : item.getPrice();
            System.out.println("Item Name : " + itemName
                    + " :: Item Code : " + slot.getCode()
                    + " :: Item Price : " + itemPrice
                    + " :: Availability : " + !slot.isSoldOut());
        }
        System.out.println();
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for (int i=0; i<slots.length; i++) {
            Item newItem = new Item();
            if (i<2) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(20);
            } else if (i < 4) {
                newItem.setItemType(ItemType.COCA_COLA);
                newItem.setPrice(25);
            }  else if (i < 6) {
                newItem.setItemType(ItemType.SPRITE);
                newItem.setPrice(15);
            }  else if (i < 8) {
                newItem.setItemType(ItemType.CHOCOLATE);
                newItem.setPrice(40);
            }  else {
                newItem.setItemType(ItemType.BISCUIT);
                newItem.setPrice(10);
            }

            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }
}