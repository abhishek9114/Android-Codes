package com.example.bt1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature_Convereter extends Activity  implements OnClickListener{

	TextView tv;
	EditText et;
	Button rb;
	CheckBox cb1,cb2;
	String output;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tempearture_converter);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		tv = (TextView) findViewById(R.id.textView);
		et = (EditText) findViewById(R.id.edText);
		rb = (Button) findViewById(R.id.bAnswer);
		cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb2 = (CheckBox)  findViewById(R.id.checkBox2);
		rb.setOnClickListener(this);	
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String p = et.getText().toString();
		if(p.length()==0)
		{
			Toast.makeText(this, "InputPlease!!!!!",2000).show();
		}
		else
		{
		  int  z = Integer.parseInt(p);
		if(cb1.isChecked() == true && cb2.isChecked() == false )
		{
		  
		float answer =(float) (z-273);
		String s = Float.toString(answer);
		output = "Result: "+ s;
		tv.setText(output);
		
		}
		else if(cb2.isChecked() == true  && cb1.isChecked() == false)
		{
			
			float answer = (float)(((z-273)*1.800)+32);
			String s = Float.toString(answer);
			output = "Result: "+ s;
			tv.setText(output);
		}
		else if(cb2.isChecked() == false  && cb1.isChecked() == false)
		{
			Toast.makeText(this, "SelectAtleastOne",2000).show();
		}
		else {
			Toast.makeText(this, "SelectOnlyOne",2000).show();
		}
		}
	}

}
