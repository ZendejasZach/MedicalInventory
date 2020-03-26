package com.example.MedicalInventory;

import java.util.Vector;

public class InventoryItem extends Vector<InventoryData> {
   private String[] item;
   private int[] amt;
   private int[] limit;
   private String[] location;
   private String[] supplier;
   private Boolean alert;
   private String[] notes;


    /**
     * Inventory Object
     * Used for one item in the inventory and its details
     *
     * @param item Name of item
     * @param amt amount of item
     * @param limit alert limit for item
     * @param location location of the item
     * @param alert if the user wants to be alerted to low amounts
     * @param notes Misc notes for the item
     * @param supplier Supplier of the item
     */
    public InventoryItem(String[] item, int[] amt, int[] limit, String[] location,
                         String[] supplier, Boolean alert, String[] notes){
       this.item = item;
       this.amt = amt;
       this.limit = limit;
       this.location = location;
       this.supplier = supplier;
       this.alert = alert;
       this.notes = notes;
    }

   /**
     * Setters
     *
     * sets details about the item
     */
    public void setAmt(int[] amt)                 {this.amt = amt;}
    public void setItem(String[] item)            {this.item = item;}
    public void setLimit(int[] limit)             {this.limit = limit;}
    public void setLocation(String[] location)    {this.location = location;}
    public void setSupplier(String[] supplier)    {this.supplier = supplier;}
    public void setAlert(Boolean alert)           {this.alert = alert;}
    public void setNotes(String[] notes)          {this.notes = notes;}

    /**
     * Getters
     *
     * get details about the item
     */
    public String[] getItem()             {return item;}
    public int[] getAmt()                 {return amt;}
    public int getLimit()               {return limit;}
    public String[] getLocation()         {return location;}
    public String[] getSupplier()         {return supplier;}
    public Boolean getAlert()             {return alert;}
    public String[] getNotes()            {return notes;}
}
