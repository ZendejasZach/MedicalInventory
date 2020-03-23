package com.example.MedicalInventory;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

       //NavBar
       BottomNavigationView navBar = (BottomNavigationView) findViewById(R.id.MainNav);
       navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item){
             switch(item.getItemId()) {
                case R.id.navManage:
                   Toast.makeText(MainPage.this, "Manage", Toast.LENGTH_SHORT).show();
                   break;
                case R.id.navHome:
                   Toast.makeText(MainPage.this, "Home", Toast.LENGTH_SHORT).show();
                   break;
                case R.id.navSettings:
                   Toast.makeText(MainPage.this, "Settings", Toast.LENGTH_SHORT).show();
                   break;
             }
             return true;
          }
       });

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
