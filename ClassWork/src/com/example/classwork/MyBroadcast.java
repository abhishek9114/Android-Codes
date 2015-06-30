package com.example.classwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyBroadcast extends Activity implements OnClickListener{
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_broadcast);
		b1 = (Button) findViewById(R.id.bbc);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Broadcast low batttery status
		Intent bl = new Intent();
		bl.putExtra("status","Battery Is Low");
		bl.putExtra("percentage","12%");
		bl.setAction("com.example.classwork.Battery_Status");
		sendBroadcast(bl);
		
	}
}
