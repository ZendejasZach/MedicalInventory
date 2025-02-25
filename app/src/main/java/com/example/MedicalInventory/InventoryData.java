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


public class InventoryData extends Activity{
    // User inventory
    private String userName;
    private File fInventory;
    private FileOutputStream outputStream;
    // TODO: Create InventoryItem class
    Vector<InventoryItem> vInventory;

/**
 * InventoryData
 * Object that holds user and inventory data
*/
public InventoryData(String filename) {
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
 * @param newItem InventoryItem object that has all the details of an item
 */
public void addItem(InventoryItem newItem){
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
 * @param filename filename that will be used for the JSON file
 */
public void save (String filename){
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
public static InventoryData load(String filename){
    InventoryData data;
    String sData = "";

   // Try and read the data
   try{
       sData = new String(Files.readAllBytes(Paths.get(filename)));
   } catch (IOException e) {
       e.printStackTrace();
   }

   //unstringify
   Gson gson = new Gson();
   data = gson.fromJson(sData, InventoryData.class);
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
     * Getters and setters
     */
    public InventoryItem getItem(int i)     {return vInventory.get(i);}
    public int getLength()                  { return vInventory.size(); }
    public String getName(int i)            { return vInventory.get(i).getItem(); }
    public int getAmt(int i)                { return vInventory.get(i).getAmt(); }
    public int getLimit(int i)              { return vInventory.get(i).getLimit(); }

}
