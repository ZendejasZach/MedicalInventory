package com.example.seniorproject;

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
    Vector<inventoryItem> vInventory;

/**
 * inventoryData
 * Object that holds user and inventory data
 * @param userName username
*/
public inventoryData(String userName, String filename) {
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
    inventoryItem newItem = new inventoryItem(item, amt, limit);
    vInventory.add(newItem);
}

/**
 * Remove item
 * Removes an item from the inventory
 * @param item item to be removed
 */
public void removeItem(inventoryItem item, Vector vInventory){
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
 * @param userName username
 * @param filename filename on device
 * @return
 */
public static inventoryData load(String userName, String filename){
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
 * Checks for pre-existingg database file
 *
 * @param userName
 * @param filename
 * @return
 */
public static Boolean checkData(String userName, String filename){
    // attempt to load file
    try{
        String data = new String(Files.readAllBytes(Paths.get(filename)));
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
}
