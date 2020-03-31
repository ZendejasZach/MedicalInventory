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
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManageItems extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_manage_items);

      // variables for inventory
      final String filename = "myMedicInventory";
      final InventoryData iData = new InventoryData(filename);

      // check for existing inventory
//      switch (data.checkData(filename))

      /**
       * Submit Button
       *
       * Takes the values in the fields and enters them into the inventory.
       */
      // Activity Variables
      final EditText itemName = (EditText) findViewById(R.id.manageItemNameField);
      final EditText itemAmt = (EditText) findViewById(R.id.manageAmtField);
      final EditText itemLocation = (EditText) findViewById(R.id.manageLocationField);
      final EditText itemSupplier = (EditText) findViewById(R.id.manageSupplierField);
      final Switch sItemAlert = (Switch) findViewById(R.id.AlertSwitch);
      final EditText itemAlertAmt = (EditText) findViewById(R.id.manageLmtField);
      final EditText itemNotes = (EditText) findViewById(R.id.manageNotesField);
      Button submitButton = (Button) findViewById(R.id.manageSubmitBtn);

      // on submit
      submitButton.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick (View v) {
            //Variables
            String sItemName = itemName.getText().toString();
            final Integer iItemAmt = Integer.valueOf(itemAmt.getText().toString());
            final String sItemLocation = itemLocation.getText().toString();
            final String sItemSupplier = itemSupplier.getText().toString();
            final Boolean bItemAlert;

            if(sItemAlert.isChecked()){
               bItemAlert = true;
            }
            else{
               bItemAlert = false;
            }

            final Integer iItemAlertAmt = Integer.valueOf(itemAlertAmt.getText().toString());
            final String sItemNotes = itemNotes.getText().toString();

            //set variables to new InventoryItem object
            InventoryItem newItem = new InventoryItem(sItemName, iItemAmt, sItemLocation, sItemSupplier, bItemAlert, iItemAlertAmt, sItemNotes);

            //Testing
            System.out.println("Name " + newItem.getItem());

            //send to inventory
            iData.addItem(newItem);
            iData.save(filename);

            //confirmation
            Toast toast = Toast.makeText(getApplicationContext(), "Inventory Item Created", Toast.LENGTH_LONG);
            toast.show();

         }
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
