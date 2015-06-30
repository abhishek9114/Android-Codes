package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ServiceDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Button startService,stopService;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_demo);
		startService  = (Button) findViewById(R.id.sdb2);
		stopService = (Button) findViewById(R.id.sdb1);
		final Intent service = new Intent(this,MyService.class);
		startService.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(service);
			}
		});
		
		stopService.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(service);
			}
		});
	}

	
}
