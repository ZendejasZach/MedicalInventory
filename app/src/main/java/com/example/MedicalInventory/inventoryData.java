package com.example.MedicalInventory;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;


public class inventoryData extends Activity{
    // User inventory
    private String userName;
    private File fInventory;
    private FileOutputStream outputStream;
    // TODO: Create InventoryItem class
    Vector<InventoryItem> vInventory;

/**
 * inventoryData
 * Object that holds user and inventory data
*/
public inventoryData(String filename) {
    this.userName = userName;

    //create blank inventory
    filename = userName + ".inv";
    fInventory = new File(Environment.getDataDirectory(), filename);

    // start inventory
    vInventory = new Vector<>();

}

/**
 * Add item
 * Add an item to the inventory vector to be saved in the inventory
 * @param item name of item to be added
 * @param amt amount of the item
 * @param limit limit for item before it alerts user to reorder
 */
public void addItem(String item, int amt, int limit){
    InventoryItem newItem = new InventoryItem(item, amt, limit);
    vInventory.add(newItem);
}

/**
 * Remove item
 * Removes an item from the inventory
 * @param item item to be removed
 */
public void removeItem(InventoryItem item, Vector vInventory){
    vInventory.remove(item);
}

/**
 * save inventory
 * Saves the items in the inventory to a JSON file on the device
 *
 * @param vInventory currently loaded inventory
 * @param filename filename that will be used for the JSON file
 */
public void save (Vector vInventory, String filename){
    // stringify
    Gson gson = new Gson();
    String json = gson.toJson(vInventory);

    //write file to device
    try {
        outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
        outputStream.write(json.getBytes());
        outputStream.close();
    } catch (Exception e){
        e.printStackTrace();
    }
}

/**
 * Loads the data from file
 *
 * @param filename filename on device
 * @return
 */
public static inventoryData load(String filename){
    inventoryData data;
    String sData = "";

   // Try and read the data
   try{
       sData = new String(Files.readAllBytes(Paths.get(filename)));
   } catch (IOException e) {
       e.printStackTrace();
   }

   //unstringify
   Gson gson = new Gson();
   data = gson.fromJson(sData, inventoryData.class);
   return data;
}

/**
 * Checks for pre-existing database file
 *
 * @param filename
 * @return
 */
public static Boolean checkData(String filename){
    // attempt to load file
    try{
        String data = new String(Files.readAllBytes(Paths.get(filename)));
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    /**
     * Checks the size of the inventory
     *
     * @return
     */
    public int getLength() {
    return vInventory.size();
    }

    /**
     * Getters and setters
     */
    public int getAmt(int i) {
        int amt;

        if (getLength() == 0){
            amt = 0;
        }
        else{
            amt = vInventory.get(i).getAmt();
        }

        return amt;

    }

    public int getLimit(int i){
        int limit;

        if (getLength() == 0)
            limit = 0;
        else
            limit = vInventory.get(i).getLimit();

        return limit;
    }

    public String getItem(int i){
       String itemName;
       if(getLength() == 0) {
           InventoryItem item = vInventory.get(i);
           itemName = item.getItem();
       }
       else
           itemName = "No items in inventory";

       return itemName;
    }
}
