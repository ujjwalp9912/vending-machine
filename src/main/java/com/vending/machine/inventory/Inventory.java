package com.vending.machine.inventory;

public class Inventory {

    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    private void initializeEmptyInventory() {
        int startCode = 101;
        for (int i=0; i<inventory.length; i++) {
            ItemShelf itemShelf = new ItemShelf(startCode, null);
            inventory[i] = itemShelf;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setSoldOut(false);
                    itemShelf.setItem(item);
                    System.out.println("Item added successfully");
                    return;
                } else {
                    System.out.println("Item is already present");
                }
            }
        }
    }

    public Item getItem(int codeNumber) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (!itemShelf.isSoldOut()) {
                    itemShelf.setSoldOut(true);
                    itemShelf.setItem(null);
                    return itemShelf.getItem();
                } else {
                    System.out.println("Item sold out");
                    return null;
                }
            }
        }

        System.out.println("Invalid code");
        return null;
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }
}
