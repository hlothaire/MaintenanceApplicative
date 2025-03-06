package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3,app.items[0].sellIn);
        assertEquals(80,app.items[0].quality);
    }

    @Test
    void agedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 3),
                new Item("Aged Brie", 5, 50),
                new Item("Aged Brie", -2, 6),
                new Item("Aged Brie", -2, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].sellIn);
        assertEquals(4,app.items[0].quality);
        assertEquals(4,app.items[1].sellIn);
        assertEquals(50,app.items[1].quality);
        assertEquals(-3,app.items[2].sellIn);
        assertEquals(8,app.items[2].quality);
        assertEquals(-3,app.items[3].sellIn);
        assertEquals(50,app.items[3].quality);
    }

    @Test
    void items() {
        Item[] items = new Item[] {
                new Item("ab", 10, 3),
                new Item("cd", 0, 50),
                new Item("ef", -2, 30),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].sellIn);
        assertEquals(2,app.items[0].quality);
        assertEquals(-1,app.items[1].sellIn);
        assertEquals(48,app.items[1].quality);
        assertEquals(-3,app.items[2].sellIn);
        assertEquals(28,app.items[2].quality);
    }

    @Test
    void backstage() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 4),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 13, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].sellIn);
        assertEquals(5,app.items[0].quality);
        assertEquals(-1,app.items[1].sellIn);
        assertEquals(0,app.items[1].quality);
        assertEquals(13,app.items[2].sellIn);
        assertEquals(5,app.items[2].quality);
        assertEquals(4,app.items[3].sellIn);
        assertEquals(23,app.items[3].quality);
        assertEquals(12,app.items[4].sellIn);
        assertEquals(50,app.items[4].quality);
    }

    @Test
    void Conjured() {
        Item[] items = new Item[] {
                new Item("Conjured", 10, 3),
                new Item("Conjured", 0, 1),
                new Item("Conjured", -2, -1),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }

}
