package com.example.MedicalInventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity {
   //Logging
   private static final String TAG = "startPage";
   InventoryData userInventory;
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

         // add items to inventory
         userInventory.addItem("Band Aids", 5, 3); //Item  should not appear under needed items
         userInventory.addItem("Trach Ties", 5, 5); // Item should appear under needed items
         userInventory.addItem("G-Tube Extension", 1, 5); // should appear under needed items
      }
      if (userInventory.checkData(filename)){
         userInventory = InventoryData.load(filename);
      }
      else{
        //TODO: show error message and prompt for new database
      }


      // Populate table
//       int size = userInventory.getLength();
//       int row = 1;
//
//       for (int i = 0; i < size; i++){
//          // set amt and limit
//          int amt = userInventory.getAmt(i);
//          int lmt = userInventory.getLimit(i);
//
//          // check if limit has been reached
//          if (amt <= lmt && lmt !=0){
//             // populate table
//             replaceText("Item", row, userInventory.getItem(i));
//             replaceText("amt", row, Integer.toString(amt));
//             replaceText("lmt", row,Integer.toString(lmt));
//             row++;
//          }
//       }
   }

//   private void replaceText(String type, int row, String text) {
//       TextView textView;

//   }


}

