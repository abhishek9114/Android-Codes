package com.example.second;

import com.example.second.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	 TextView ref ;
   EditText r1,r2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ref = (TextView)findViewById(R.id.mat1);
		r1 = (EditText)findViewById(R.id.editText1);
		r2 = (EditText)findViewById(R.id.number2);
	}
	
	public void firstAction(View v)
    {
		String  c = r1.getText().toString();
		int p = Integer.parseInt(c);
		String c1 = r2.getText().toString();
		int p1 = Integer.parseInt(c1);
		int z = p+p1;
    	ref.setText("Result="+z);
    }
 public void secondAction(View v)
	{
	 String  c = r1.getText().toString();
		int p = Integer.parseInt(c);
		String c1 = r2.getText().toString();
		int p1 = Integer.parseInt(c1);
		int z = p1-p;
 	ref.setText("Result="+z);	
	}
   
	
public void thirdAction(View v)
{
	String  c = r1.getText().toString();
	int p = Integer.parseInt(c);
	String c1 = r2.getText().toString();
	int p1 = Integer.parseInt(c1);
	int z = p*p1;
	ref.setText("Result="+z);
}
public void fourthAction(View v)
{
	String  c = r1.getText().toString();
	int p = Integer.parseInt(c);
	String c1 = r2.getText().toString();
	int p1 = Integer.parseInt(c1);
	int z = p/p1;
	ref.setText("Result="+z);
	
}
}
