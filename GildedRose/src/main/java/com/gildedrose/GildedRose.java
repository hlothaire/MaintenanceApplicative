package com.gildedrose;

class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
       for (Item item : items) {
           switch (item.name) {
               case AGED_BRIE:
                   handleAgedBrie(item);
                   break;
               case SULFURAS_HAND_OF_RAGNAROS:
                   handleSulfuras(item);
                   break;
               case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                   handleBackstage(item);
                   break;
               case "Conjured":
                   handleConjured(item);
                   break;
               default:
                   handleRegular(item);
                   break;
           }
       }
    }

    public void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 0 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
    }

    public void handleSulfuras(Item item) {
    }

    public void handleBackstage(Item item) {
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

    public void handleRegular(Item item) {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 1 : 2);
        }
        item.sellIn--;
    }

    public void handleConjured(Item item) {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 2 : 4);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

}
