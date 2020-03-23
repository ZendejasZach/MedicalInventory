package com.example.MedicalInventory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //NavBar
        BottomNavigationView navBar = findViewById(R.id.MainNav);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()) {
                    case R.id.navManage:
                        Toast.makeText(Settings.this, "Manage", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Settings.this, ManageItems.class));
                        break;
                    case R.id.navHome:
                        Toast.makeText(Settings.this, "Home", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Settings.this, MainPage.class));
                        break;
                    case R.id.navSettings:
                        Toast.makeText(Settings.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
	//Notes
	//Sorting settings for home page
	//sorting settings for reorder page
	//Option to replay initial video
	//Option to remove JSON file and start fresh
}
