package be.cegeka.brownbags.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayToDayTest {

    private Item[] items;

    private String expected_day1 = "-------- day 1 --------name, sellIn, quality+5 Dexterity Vest, 9, 19Aged Brie, 1, 1Elixir of the Mongoose, 4, 6Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 14, 21Backstage passes to a TAFKAL80ETC concert, 9, 50Backstage passes to a TAFKAL80ETC concert, 4, 50Conjured Mana Cake, 2, 5";
    private String expected_day2 = "-------- day 2 --------name, sellIn, quality+5 Dexterity Vest, 8, 18Aged Brie, 0, 2Elixir of the Mongoose, 3, 5Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 13, 22Backstage passes to a TAFKAL80ETC concert, 8, 50Backstage passes to a TAFKAL80ETC concert, 3, 50Conjured Mana Cake, 1, 4";
    private String expected_day3 = "-------- day 3 --------name, sellIn, quality+5 Dexterity Vest, 7, 17Aged Brie, -1, 4Elixir of the Mongoose, 2, 4Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 12, 23Backstage passes to a TAFKAL80ETC concert, 7, 50Backstage passes to a TAFKAL80ETC concert, 2, 50Conjured Mana Cake, 0, 3";
    private String expected_day4 = "-------- day 4 --------name, sellIn, quality+5 Dexterity Vest, 6, 16Aged Brie, -2, 6Elixir of the Mongoose, 1, 3Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 11, 24Backstage passes to a TAFKAL80ETC concert, 6, 50Backstage passes to a TAFKAL80ETC concert, 1, 50Conjured Mana Cake, -1, 1";
    private String expected_day5 = "-------- day 5 --------name, sellIn, quality+5 Dexterity Vest, 5, 15Aged Brie, -3, 8Elixir of the Mongoose, 0, 2Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 10, 25Backstage passes to a TAFKAL80ETC concert, 5, 50Backstage passes to a TAFKAL80ETC concert, 0, 50Conjured Mana Cake, -2, 0";
    private String expected_day6 = "-------- day 6 --------name, sellIn, quality+5 Dexterity Vest, 4, 14Aged Brie, -4, 10Elixir of the Mongoose, -1, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 9, 27Backstage passes to a TAFKAL80ETC concert, 4, 50Backstage passes to a TAFKAL80ETC concert, -1, 0Conjured Mana Cake, -3, 0";
    private String expected_day7 = "-------- day 7 --------name, sellIn, quality+5 Dexterity Vest, 3, 13Aged Brie, -5, 12Elixir of the Mongoose, -2, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 8, 29Backstage passes to a TAFKAL80ETC concert, 3, 50Backstage passes to a TAFKAL80ETC concert, -2, 0Conjured Mana Cake, -4, 0";
    private String expected_day8 = "-------- day 8 --------name, sellIn, quality+5 Dexterity Vest, 2, 12Aged Brie, -6, 14Elixir of the Mongoose, -3, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 7, 31Backstage passes to a TAFKAL80ETC concert, 2, 50Backstage passes to a TAFKAL80ETC concert, -3, 0Conjured Mana Cake, -5, 0";
    private String expected_day9 = "-------- day 9 --------name, sellIn, quality+5 Dexterity Vest, 1, 11Aged Brie, -7, 16Elixir of the Mongoose, -4, 0Sulfuras, Hand of Ragnaros, 0, 80Sulfuras, Hand of Ragnaros, -1, 80Backstage passes to a TAFKAL80ETC concert, 6, 33Backstage passes to a TAFKAL80ETC concert, 1, 50Backstage passes to a TAFKAL80ETC concert, -4, 0Conjured Mana Cake, -6, 0";

    @Before
    public void setUp() throws Exception {
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }

    @Test
    public void allDays() {
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertThat(calculateResult(items, 1)).isEqualTo(expected_day1);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 2)).isEqualTo(expected_day2);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 3)).isEqualTo(expected_day3);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 4)).isEqualTo(expected_day4);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 5)).isEqualTo(expected_day5);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 6)).isEqualTo(expected_day6);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 7)).isEqualTo(expected_day7);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 8)).isEqualTo(expected_day8);
        gildedRose.updateQuality();
        assertThat(calculateResult(items, 9)).isEqualTo(expected_day9);
    }

    private String calculateResult(Item[] items, int days) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-------- day " + days + " --------");
        stringBuilder.append("name, sellIn, quality");
        for (Item item : items) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }
}
