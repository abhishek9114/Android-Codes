package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Assignment_class extends Activity implements OnClickListener{
	Button b1,b2,b3,b4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assignment_class);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.button1)
		{
			String s = "com.example.bt1.";
			String p = b1.getText().toString();
			 s = s+p;
			 try {
					Class c = Class.forName(s);
					Intent myintent = new Intent(this , c);
					startActivity(myintent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					String em = "Error";
				}
			 
		}
		else if(v.getId()==R.id.button2){
			String s = "com.example.bt1.";
			String p = b2.getText().toString();
			 s = s+p;
			 try {
					Class c = Class.forName(s);
					Intent myintent = new Intent(this , c);
					startActivity(myintent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					String em = "Error";
				}
			 
			
		}
		else if(v.getId()==R.id.button3){
			String s = "com.example.bt1.";
			String p = b3.getText().toString();
			 s = s+p;
			 try {
					Class c = Class.forName(s);
					Intent myintent = new Intent(this , c);
					startActivity(myintent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					String em = "Error";
				}
			 
			
		}
		else
		{
			String s = "com.example.bt1.";
			String p = b4.getText().toString();
			 s = s+p;
			 try {
					Class c = Class.forName(s);
					Intent myintent = new Intent(this , c);
					startActivity(myintent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					String em = "Error";
				}
			 
			
		}
	}

}
