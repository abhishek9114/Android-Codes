package com.example.bt1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonDemo extends Activity implements OnClickListener{

	ToggleButton t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_button_demo);
		t1 = (ToggleButton) findViewById(R.id.tb);
		t1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(t1.isChecked())
		{
			Toast.makeText(ToggleButtonDemo.this, "Speakerenabled", 2000).show();
		}
		else
			Toast.makeText(ToggleButtonDemo.this, "Speakerdisabled", 2000).show();
		
	}

	
}
