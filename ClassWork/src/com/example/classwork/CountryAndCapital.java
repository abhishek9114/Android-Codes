package com.example.classwork;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class CountryAndCapital extends Activity implements OnItemClickListener{

	String []country = {"India","France","Bengladesh","Nepal","USA","Australlia"};
	String []capital = {"Capital of India is Delhi","Capital of France is Paris","Capital of Bengladesh is Dhaka","Capital of Nepal is Katmandu","Capital of USA is Wash-DC","Capital of Australlia is Sydney"};
	AutoCompleteTextView actv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_and_capital);
		actv = (AutoCompleteTextView) findViewById(R.id.actv);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,country);
		actv.setAdapter(ad);
		actv.setOnItemClickListener(this);
		actv.setTextColor(Color.RED);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		String s = actv.getText().toString();
		String p = "";
		for(int i=0;i<country.length;i++)
		{
		if(country[i].equals(s))
		{
			actv.setText(capital[i]);
		}
		}
	}
}
