package com.example.MedicalInventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ManageItems extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_manage_items);

      //Navbar
      BottomNavigationView navBar = findViewById(R.id.MainNav);
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
