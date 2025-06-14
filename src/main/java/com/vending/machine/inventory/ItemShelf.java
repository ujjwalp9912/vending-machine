package com.vending.machine.inventory;

public class ItemShelf {

    private int code;
    private Item item;
    private boolean isSoldOut;

    public ItemShelf(int code, Item item) {
        this.code = code;
        this.item = item;
        this.isSoldOut = true;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.isSoldOut = soldOut;
    }

    public int getCode() {
        return code;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
