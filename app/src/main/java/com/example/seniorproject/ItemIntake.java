package com.example.seniorproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ItemIntake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_intake);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

	// Pseudocode section
	//
	//Build page
	//	Item Name field
	//	Item count field
	//		increase and decrease buttons
	//	Supplier
	//	ReOrder amount
	//		--This is the amount that they will need to reorder and will appear in the reorder screen-- 
	//	Notes section
	//
	//Check for existing inventory file
	//	if no file, create blank either now or after first intake submit
	//	if file, load supplier information
	//populate supplier information into supplier dropdown.
	//Once submit is clicked, input data into JSON file
	//	--Should some fields be required?--
	//
	//Once submitted prompt for additional submissions or return to home screen?
	//	--Potential feature is bulk import--
	//
	//Also add barcode scanning functionality if time permits.

}
