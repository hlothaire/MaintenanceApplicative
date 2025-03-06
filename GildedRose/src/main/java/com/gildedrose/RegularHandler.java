package com.gildedrose;

public class RegularHandler extends Handler{

    public RegularHandler(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 1 : 2);
        }
        item.sellIn--;
    }
}
