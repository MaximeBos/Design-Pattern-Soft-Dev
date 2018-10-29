package edu.insightr.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void updateQuality()
    {
        Item Veste = new Item("+5 Dexterity Vest",10,20);
        Item Brie = new Item("Aged Brie", 2, 0);
        Item Sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item Backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Item Conjured = new Item("Conjured Mana Cake", 3, 6);

        Item[] items = new Item[5];
        items[0] = Veste;
        items[1] = Brie;
        items[2] = Sulfuras;
        items[3] = Backstage;
        items[4] = Conjured;

        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();

        assertEquals(19, items[0].getQuality());
        assertEquals(1, items[1].getQuality());
        assertEquals(80, items[2].getQuality());
        assertEquals(21, items[3].getQuality());
        assertEquals(4, items[4].getQuality());
    }

    @Test
    void TestVest()
    {
        Item Vest = new Item("+5 Dexterity Vest", 10, 10);
        Item[] items = new Item[1];
        items[0] = Vest;

        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();

        assertEquals(9, Vest.getQuality());
    }

    @Test
    void TestAgedBrie()
    {
        Item AgedBrie = new Item("Aged Brie", 10, 10);

        Item[] items = new Item[1];
        items[0] = AgedBrie;
        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();

        assertEquals(11, AgedBrie.getQuality());
    }

    @Test
    void TestBackstage()
    {
        Item BackstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10);
        Item BackstagePass2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        Item BackstagePass3 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        Item BackstagePass4 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);

        Item[] items = new Item[4];
        items[0] = BackstagePass;
        items[1] = BackstagePass2;
        items[2] = BackstagePass3;
        items[3] = BackstagePass4;

        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();

        assertEquals(11,BackstagePass.getQuality());
        assertEquals(12,BackstagePass2.getQuality());
        assertEquals(13,BackstagePass3.getQuality());
        assertEquals(0, BackstagePass4.getQuality());
    }

    @Test
    void TestSulfuras()
    {
        Item Sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Item[] items = new Item[1];
        items[0] = Sulfuras;

        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();

        assertEquals(80,Sulfuras.getQuality());
    }

    @Test
    void testConjured()
    {
        Item Conjured = new Item("Conjured Mana Cake", 10, 10);
        Item[] items = new Item[1];
        items[0] = Conjured;
        Inventory inventaire = new Inventory(items);
        inventaire.updateQuality();
        assertEquals(8, Conjured.getQuality());
    }
}