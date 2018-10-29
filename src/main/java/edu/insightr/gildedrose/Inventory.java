package edu.insightr.gildedrose;

public class Inventory {

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality()
    {
        for (Item item : items)
        {
            if ("Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                continue;
            }
            if("Aged Brie".equals(item.getName()))
            {
                item.setSellIn(item.getSellIn() - 1);
                addQuality(item);

                if (item.getSellIn() < 0)
                {
                    addQuality(item);
                }
            }

            else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
            {
                item.setSellIn(item.getSellIn() - 1);
                addQuality(item);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                {
                    if (item.getSellIn() < 10)
                    {
                        addQuality(item);
                    }

                    if (item.getSellIn() < 5)
                    {
                        addQuality(item);
                    }

                    if (item.getSellIn() < 0)
                    {
                        item.setQuality(0);
                    }
                }
            }

            else if (item.getName().matches(".*Conjured.*"))
            {
                item.setSellIn(item.getSellIn() - 1);
                doubleLowerQuality(item);
            }

            else
            {
                item.setSellIn(item.getSellIn() - 1);
                lowerQuality(item);

                if (item.getSellIn() < 0)
                {
                    lowerQuality(item);
                }
            }
        }
    }

    protected void addQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    protected void lowerQuality(Item item) {
        if (item.getQuality() > 0)
        {
            item.setQuality(item.getQuality() - 1);
        }
    }

    protected void doubleLowerQuality(Item item) {
        lowerQuality(item);
        lowerQuality(item);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}


    //1- Add to github and add a TAG
    //2- Create a branch named "visitor"
    //3- use the visitor patter

