package com.example.stock_overflow;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.widget.TabHost.*;


public class MainActivity extends TabActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		// Set the main form
		setContentView(R.layout.activity_main);
		
		// Create the tab navigator
		TabHost tab = getTabHost ();
		
		// Create the intent(s) for the tabs
		//Intent LaunchSettings = new Intent ( this, null );
		
		// Create our tab spec(s)
		TabSpec Settings = tab.newTabSpec("Settings");
		//Settings.setContent(LaunchSettings);
		Settings.setIndicator("Settings");
		
		// Add the tab host
		tab.addTab ( Settings );		
	}
}
