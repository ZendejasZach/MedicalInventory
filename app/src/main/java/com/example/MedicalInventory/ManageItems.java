package com.example.MedicalInventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManageItems extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_manage_items);

      // variables for inventory
      String filename = "myMedicInventory";
      InventoryData data = new InventoryData(filename);

      // check for existing inventory
      switch (data.checkData(filename))

      /**
       * Submit Button
       *
       * Takes the values in the fields and enters them into the inventory.
       */
      //Variables
      final String[] sItemName = new String[1];
      final int[] iItemAmt = new int[1];
      final String[] sItemLocation = new String[1];
      final String[] sItemSupplier = new String[1];
      final boolean bItemAlert = false;
      final int[] iItemAlertAmt = new int[1];
      final String[] sItemNotes = new String[1];

      final EditText itemName;
      final EditText itemAmt;
      final EditText itemLocation;
      final EditText itemSupplier;
      Switch itemAlert;
      final EditText itemAlertAmt;
      EditText itemNotes = null;
      Button submitButton;

      //Grab values
      itemName = (EditText) findViewById(R.id.manageItemNameField);
      itemAmt = (EditText) findViewById(R.id.manageAmtField);
      itemLocation = (EditText) findViewById(R.id.manageLocationField);
      itemSupplier = (EditText) findViewById(R.id.manageSupplierField);
      itemAlert = (Switch) findViewById(R.id.switch3);
      itemAlertAmt = (EditText) findViewById(R.id.manageLmtField);
      submitButton = (Button) findViewById(R.id.manageSubmitBtn);

      final EditText finalItemNotes = itemNotes;
      submitButton.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick (View v) {
            sItemName[0] = itemName.getText().toString();
            iItemAmt[0] = Integer.valueOf(itemAmt.getText().toString());
            sItemLocation[0] = itemLocation.getText().toString();
            sItemSupplier[0] = itemSupplier.getText().toString();
            //TODO: find how to cast Bool.
//            bItemAlert = itemAlert.getText().toString();
            iItemAlertAmt[0] = Integer.valueOf(itemAlertAmt.getText().toString());
            sItemNotes[0] = finalItemNotes.getText().toString();
         }

         //set variables to new InventoryItem object
         InventoryItem newItem = new InventoryItem(sItemName, iItemAmt, iItemAlertAmt, sItemLocation, sItemSupplier, bItemAlert, sItemNotes);

         // insert item into inventory

      });


      //Navbar
      BottomNavigationView navBar = findViewById(R.id.navManage);
      navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item){
            switch(item.getItemId()){
               case R.id.navManage:
                  break;
               case R.id.navHome:
                  startActivity(new Intent(ManageItems.this, MainPage.class));
                  break;
               case R.id.navSettings:
                  startActivity(new Intent(ManageItems.this, Settings.class));
                  break;
            }
            return true;
         }
      });
   }
}
