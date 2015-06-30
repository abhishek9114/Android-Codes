package com.example.bt1;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Textgame extends Activity {
	
	Button chkcmd;
    ToggleButton passtog;
    EditText input;
    TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
	newreferencemethod();	
		passtog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(passtog.isChecked())
				{
					input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}else{
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
				
			}
		});
		chkcmd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String check = input.getText().toString();
				if(check.contentEquals("left"))
				{
					display.setGravity(Gravity.LEFT);
					input.setGravity(Gravity.CENTER | Gravity.BOTTOM);
				}
				if(check.contentEquals("left"))
				{
				display.setGravity(Gravity.LEFT);	
				}
				else if(check.contentEquals("center")){
					display.setGravity(Gravity.CENTER);
				}
				else if(check.contentEquals("right")){
					display.setGravity(Gravity.RIGHT);
				}
				else if(check.contentEquals("blue")){
					display.setTextColor(Color.BLUE);
					
				}
				else if(check.contentEquals("WTF")){
					Random crazy = new Random();
					display.setText("WTF!!!!!");
					display.setTextSize(crazy.nextInt(75));
					display.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265), crazy.nextInt(265)));
					switch(crazy.nextInt(3))
					{
					case 0:
						display.setGravity(Gravity.LEFT);
						break;
						
					case 1:
						display.setGravity(Gravity.CENTER);
						break;
						
					case 2:
						display.setGravity(Gravity.RIGHT);
						break;
					}
				}else
				{
					display.setText("invalid");
					display.setGravity(Gravity.RIGHT);
					display.setTextColor(Color.WHITE);
				}
			}
		});
	}
	private void newreferencemethod() {
		// TODO Auto-generated method stub
		chkcmd = (Button)findViewById(R.id.bResults);
		 passtog = (ToggleButton) findViewById(R.id.tbPassword);
			 input = (EditText) findViewById (R.id.etCommands);
			 display = (TextView) findViewById (R.id.tvResults);
		
	}
	

}
