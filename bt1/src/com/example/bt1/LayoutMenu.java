package com.example.bt1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LayoutMenu extends ListActivity {
  
	String [] mi = {"Alone", "LinearDemo","TableDemo","FrameDemo","TabMenu"
			
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class_menu);
		ArrayAdapter ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi);
		setListAdapter(ad);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String [] zi = { "Alone", "LinearDemo","TableDemo","FrameDemo","TabMenu"};
		super.onListItemClick(l, v, position, id);
		String ci = zi[position];
		if(ci.equals("EXIT")){
			finish();
		}
		else
		{
			String s = "com.example.bt1.";
			//String p = b2.getText().toString();
			 s = s+ci;
			 try {
					Class c = Class.forName(s);
					Intent myintent = new Intent(this , c);
					startActivity(myintent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					String em = "Error";
				}
		}
		//Toast.makeText(this, "CLICKED : "+ ci, 1000).show();;
	}
}
