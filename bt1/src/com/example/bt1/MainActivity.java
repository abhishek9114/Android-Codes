package com.example.bt1;

import com.example.bt1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	TextView ref ;
	  int c=0;
	  Button  inc, dec ,sm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ref = (TextView)findViewById(R.id.mat1);
		inc = (Button)findViewById(R.id.mab2);
		dec =  (Button)findViewById(R.id.mab3);
		sm = (Button)findViewById(R.id.mab1); 
		inc.setOnClickListener(this);
		dec.setOnClickListener(this);
		sm.setOnClickListener(this);
		String msg = "WELCOME!!!!!";
		Toast t= Toast.makeText(this,msg,Toast.LENGTH_LONG);
		t.show();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId()==R.id.mab2)
		{
		c++;
		String msg = "COUNTER : "+c;
		ref.setText(msg);
		}
		else if(v.getId()==R.id.mab3)
		{
			c--;
			String msg = "COUNTER : "+c; 
			ref.setText(msg);
		}
		else
		{
			String s = "com.example.bt1.Lifecycle_activity";
			try {
				Class c = Class.forName(s);
				Intent myintent = new Intent(this , c);
				startActivity(myintent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				String em = "Error";
			Toast.makeText(this, em, 2000);
			}
		}
	}
	
}
