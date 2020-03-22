package com.example.MedicalInventory;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    //Logging
    private static final String TAG = "startPage";
    inventoryData userInventory;
    String filename = "medicalInv.data";
    boolean testing = true;

    /**
     * Activity Creation
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       // check for existing database
       if(testing == true){
          //create test database
          userInventory = new inventoryData(filename);

          // add items to inventory
          userInventory.addItem("Band Aids", 5, 3); //Item  should not appear under needed items
          userInventory.addItem("Trach Ties", 5, 5); // Item should appear under needed items
          userInventory.addItem("G-Tube Extension", 1, 5); // should appear under needed items
       }
       if (userInventory.checkData(filename)){
          userInventory = inventoryData.load(filename);
       }
       else{
         //TODO: show error message and prompt for new database
       }


       // Populate table
       int size = userInventory.getLength();
       int row = 1;

       for (int i = 0; i < size; i++){
          // set amt and limit
          int amt = userInventory.getAmt(i);
       }

       // Load user data


    }
}
