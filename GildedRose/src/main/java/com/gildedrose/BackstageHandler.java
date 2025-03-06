package com.gildedrose;

public class BackstageHandler extends Handler{

    public BackstageHandler(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.sellIn > 0) {
            if (item.quality < 50) {
                item.quality++;
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
