package com.gildedrose;

public abstract class Handler {
    protected Item item;

    public Handler(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();
}
