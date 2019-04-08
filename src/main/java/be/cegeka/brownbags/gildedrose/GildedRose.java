package be.cegeka.brownbags.gildedrose;

public class GildedRose {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item currentItem : items) {
            if (currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                continue;
            }

            if (currentItem.name.equals(BACKSTAGE_PASS)) {
                if (currentItem.quality < 50) {
                    currentItem.increaseQuality();

                    if (currentItem.quality < 50) {
                        if (currentItem.sellIn < 11) {
                            currentItem.increaseQuality();
                        }
                    }

                    if (currentItem.quality < 50) {
                        if (currentItem.sellIn < 6) {
                            currentItem.increaseQuality();
                        }
                    }
                }

                currentItem.decreaseSellIn();

                if (currentItem.sellIn < 0) {
                    currentItem.quality = 0;
                }
                continue;
            }

            if (currentItem.name.equals(AGED_BRIE)) {

                if (currentItem.quality < 50) {
                    currentItem.increaseQuality();
                }

                currentItem.decreaseSellIn();

                if (currentItem.sellIn < 0) {
                    if (currentItem.quality < 50) {
                        currentItem.increaseQuality();
                    }
                }
                continue;
            }

            if (currentItem.quality > 0) {
                currentItem.decreaseQuality();
            }

            currentItem.decreaseSellIn();

            if (currentItem.sellIn < 0) {
                if (currentItem.quality > 0) {
                    currentItem.decreaseQuality();
                }
            }

        }
    }

}
