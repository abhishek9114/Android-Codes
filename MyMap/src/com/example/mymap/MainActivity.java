package com.example.mymap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {


	GoogleMap gm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gm=((MapFragment)getFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		gm.setMapType(gm.MAP_TYPE_SATELLITE);
	}
}
