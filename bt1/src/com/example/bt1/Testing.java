package com.example.bt1;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Testing extends Activity implements OnClickListener{
	TextView tv1;
   Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testing);
		tv1 = (TextView) findViewById(R.id.testview);
		b1 = (Button) findViewById(R.id.button);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int p = r.nextInt(4);
		String result = "Result = " + p;
		tv1.setText(result);
	}
}
