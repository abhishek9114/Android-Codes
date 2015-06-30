package com.example.bt1;

import java.util.Random;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Alone extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView tv1 = new TextView(this);
		tv1.setText("Alone Activity");
		Bundle bund = getIntent().getExtras();
		String bs = bund.getString("bs");
		tv1.append(bs);
		Button b1 = new Button(this);
		Button b2 = new Button(this);
		b1.setText("CLICK HERE");
		b2.setText("EXIT");
		LinearLayout l1 = new LinearLayout(this);
		l1.setOrientation(LinearLayout.VERTICAL);
		l1.addView(tv1);
		l1.addView(b1);
		l1.addView(b2);
		int r,g,b;
		Random rc = new Random();
		r = rc.nextInt(255);
		b= rc.nextInt(255);
		g = rc.nextInt(255);
		l1.setBackgroundColor(Color.rgb(r, g, b));
		setContentView(l1);
	}

}
