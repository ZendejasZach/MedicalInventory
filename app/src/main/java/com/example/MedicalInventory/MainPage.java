package com.example.MedicalInventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;
import java.util.List;

public class MainPage extends AppCompatActivity {
   // variables
   private static final String TAG = "startPage";
   InventoryData userInventory;
   String filename = "medicalInv.data";
   boolean testing = true;
   private ListView myList;

   /**
    * Activity Creation
    *
    * @param savedInstanceState
    */
   @Override
   protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      //NavBar
      BottomNavigationView navBar = findViewById(R.id.MainNav);
      navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()) {
               case R.id.navManage:
//                  Log.v(TAG, "Manage Button Tapped from MainPage");
//                  Toast.makeText(MainPage.this, "Manage", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(MainPage.this, ManageItems.class));
                  break;
               case R.id.navHome:
//                  Log.v(TAG, "Home button tapped from MainPage");
//                  Toast.makeText(MainPage.this, "Home", Toast.LENGTH_SHORT).show();
                  break;
               case R.id.navSettings:
//                  Log.v(TAG, "Settings button tapped from MainPage");
//                  Toast.makeText(MainPage.this, "Settings", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(MainPage.this, Settings.class));
                  break;
            }
            return true;
         }
      });

      // check for existing database
      if(testing == true){
         //create test database
         userInventory = new InventoryData(filename);

         // Create test items
         InventoryItem test1 = new InventoryItem("BandAids", 5, "Closet", "Acme Meds", true, 5, "Things and notes");
         InventoryItem test2 = new InventoryItem("Trachs", 1, "Closet", "Acme Meds", false, 5, "Things and notes");
         InventoryItem test3 = new InventoryItem("G-Tube Pads", 15, "Closet", "Acme Meds", true, 10, "Things and notes");

         // Add items to inventory
         userInventory.addItem(test1);
         userInventory.addItem(test2);
         userInventory.addItem(test3);

         // save inventory
         userInventory.save(filename);
      }
      if (userInventory.checkData(filename)){
         userInventory = InventoryData.load(filename);
      }
      else{
        //TODO: show error message and prompt for new database
      }

      // Populate items for listView
      int size = userInventory.getLength();
      String name[] = new String[size];
      String amt[] = new String[size];
      String limit[] = new String[size];

      for (int i = 0; i < userInventory.getLength(); i++){
         name[i] = userInventory.getName(i);
         amt[i] = String.valueOf(userInventory.getAmt(i));
         limit[i] = String.valueOf(userInventory.getLimit(i));
      }
      // populate listView

      myList = (ListView) findViewById(R.id.MainPageList);
      ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
              this,
              android.R.layout.simple_list_item_1,
              name);

      ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
              this,
              android.R.layout.simple_list_item_2,
              amt);

      myList.setAdapter(arrayAdapter1);
      myList.setAdapter(arrayAdapter2);
   }
}

