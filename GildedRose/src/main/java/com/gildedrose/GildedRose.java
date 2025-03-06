package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Handler getHandler(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieHandler(item);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasHandler(item);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackstageHandler(item);
            case "Conjured":
                return new ConjuredHandler(item);
            default:
                return new RegularHandler(item);
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            Handler handler = getHandler(item);
            handler.updateQuality();
        }
    }

}
