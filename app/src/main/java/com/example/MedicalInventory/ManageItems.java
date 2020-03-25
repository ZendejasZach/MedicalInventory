package com.example.MedicalInventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManageItems extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_manage_items);

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
