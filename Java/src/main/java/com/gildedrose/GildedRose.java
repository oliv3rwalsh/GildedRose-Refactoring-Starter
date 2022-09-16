package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // if not brie or concert tickets
                if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // if quality > 0 and not sulfuras
                    items[i].quality--;
                }
            } else if (items[i].quality < 50) { // if brie or concert tickets AND quality < 50
                items[i].quality++;
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && items[i].sellIn < 11) { // if concert tickers and sell in < 11
                    items[i].quality++;
                    if(items[i].sellIn < 6){ // if sell in < 6
                        items[i].quality++;
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // if not sulfuras
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) { // if past sell in date
                if (!items[i].name.equals("Aged Brie")) { // if not aged brie
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // if not concert tickets
                        if (items[i].quality > 0 && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) { 
                            items[i].quality--;
                        }
                    } else { // if concert tickets
                        items[i].quality = 0;
                    }
                } else { // if aged brie
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }
}