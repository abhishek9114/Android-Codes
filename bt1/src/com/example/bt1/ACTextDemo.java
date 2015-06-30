package com.example.bt1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ACTextDemo extends Activity {

	AutoCompleteTextView actv;
	String [] data = {"Android","Activity","Australlia","India","Indonesia","China"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actext_demo);
		 actv = (AutoCompleteTextView) findViewById (R.id.actv1);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
		actv.setAdapter(ad);
		actv.setTextColor(Color.RED);
	}

}
