package com.example.MedicalInventory;

import java.util.Vector;

public class InventoryItem extends Vector<inventoryData> {
   private String item;
   private int amt;
   private int limit;

    /**
     * Inventory Object
     * Used for one item in the inventory and its details
     *
     * @param item Name of item
     * @param amt amount of item
     * @param limit alert limit for item
     */
    public InventoryItem(String item, int amt, int limit){
       this.item = item;
       this.amt = amt;
       this.limit = limit;
    }

    /**
     * Setters
     *
     * sets details about the item
     */
    public void setAmt(int amt)         {this.amt = amt;}
    public void setItem(String item)    {this.item = item;}
    public void setLimit(int limit)     {this.limit = limit;}

    /**
     * Getters
     *
     * get details about the item
     */
    public String getItem()             {return item;}
    public int getAmt()                 {return amt;}
    public int getLimit()               {return limit;}
}
