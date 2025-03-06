package com.gildedrose;

public class ConjuredHandler extends Handler{

    public ConjuredHandler(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 2 : 4);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
