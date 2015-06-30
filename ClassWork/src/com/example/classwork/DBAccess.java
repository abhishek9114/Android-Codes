package com.example.classwork;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;


public class DBAccess extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dbaccess);
		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(HPContract.STP15_URI, null, null, null,null);
		String sdata = "";
		while(c.moveToNext()==true)
		{
			String roll = c.getString(0);
			String name = c.getString(1);
			sdata += (roll+" : "+name)+"\n"; 
		}
		Toast.makeText(this,sdata , Toast.LENGTH_LONG).show();
	}
}
