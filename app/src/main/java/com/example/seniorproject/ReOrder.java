package com.example.seniorproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ReOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_order);
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
	
	//Pseudocode
	//Load JSON file
	//	if no file, throw error
	//	if no data in JSON file, throw error
	//Organize by supplier then alphabetical order.
	//	--Change sorting in settings?--
	//	--add checkmark to mark something re-ordered?--
	//	--Potentially add a mark all button--
	//Show item
	//	Name
	//	current count
	//	ReOrder Amount (From Intake)
	//Show supplier information
	//	Name
	//	Contact
	//	Phone number
	//		Tapping number will send the number to the dialer. --May need to add this to SRS document--

}
