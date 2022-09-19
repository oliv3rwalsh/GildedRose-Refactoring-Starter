package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void Sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }
    @Test
    void Tickets() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void Brie() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    @Test
    void CBologna() {
        Item[] items = new Item[] { new Item("Conjured Bologna", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

}
