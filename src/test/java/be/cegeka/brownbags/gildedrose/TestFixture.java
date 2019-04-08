package be.cegeka.brownbags.gildedrose;

public class TestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 10;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        System.out.println(calculateResult(items, app, days));
    }

    private static String calculateResult(Item[] items, GildedRose app, int days) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < days; i++) {
            stringBuilder.append("-------- day " + i + " --------");
            stringBuilder.append("name, sellIn, quality");
            for (Item item : items) {
                stringBuilder.append(item);
            }
            stringBuilder.append("\n");
            app.updateQuality();
        }
        return stringBuilder.toString();
    }
}
