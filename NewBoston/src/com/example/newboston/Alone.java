package com.example.newboston;

import java.util.Random;

import android.R.color;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
		SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(this);
		String color = s.getString("scolor", "WHITE");
		//for check box ->    boolean i = s.getBoolean("t9hint","false")
		//for multiselectlistboxpreference  Set<string> colors;
		//colors = s.getstring("mcolor",null);
		if(color.equals("RED"))
		l1.setBackgroundColor(Color.RED);
		else if(color.equals("BLACK"))
			l1.setBackgroundColor(Color.BLACK);
		else if(color.equals("BLUE"))
			l1.setBackgroundColor(Color.BLUE);
		else if(color.equals("ORANGE"))
			l1.setBackgroundColor(Color.rgb(0xFF, 0x7F,0x2A));
		else
			l1.setBackgroundColor(Color.WHITE);
		setContentView(l1);
	}

}
