package com.vending.machine.inventory;

public class Item {

    private ItemType itemType;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
