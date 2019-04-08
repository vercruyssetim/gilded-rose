package be.cegeka.brownbags.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void decreaseQuality() {
        quality = quality - 1;
    }

    void increaseQuality() {
        quality = quality + 1;
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }
}
