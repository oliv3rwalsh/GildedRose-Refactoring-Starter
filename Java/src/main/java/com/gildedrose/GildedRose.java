package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i].name.equals("Aged Brie") || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                if (items[i].quality < 50) {
                    items[i].quality++;
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && (items[i].sellIn < 11 || items[i].sellIn < 6) && items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            } else {
                // if not aged brie and not concert tickets
                if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // if quality > 0 and not sulfuras
                    items[i].quality--;
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // if not sulfuras
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0) { // if past sell by date
                if(items[i].name.equals("Aged Brie")){
                    if (items[i].quality < 50) { // increase quality if quality < 50
                        items[i].quality++;
                    }
                } else {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality--;
                    } else {
                        items[i].quality = 0; 
                    }
                }
            }
        }
    }
}