package com.gildedrose;

public class AgedBrieHandler extends Handler{

    public AgedBrieHandler(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 0 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
    }
}
