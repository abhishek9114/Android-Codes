package com.example.androiddatabase;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class EmployeeDatabase extends Activity implements OnClickListener{

	Button b1,b2,b3;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_employee_database);
		b1 = (Button) findViewById(R.id.dbb1);
		b2 = (Button) findViewById(R.id.dbb2);
		b3 = (Button) findViewById(R.id.dbb3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		db = openOrCreateDatabase("stp15",MODE_WORLD_READABLE, null );
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		
		case R.id.dbb1 :
			//create Table
			String ctq = "create table if not exists emp(rollno int(4), sname varchar , dept varchar);";
			db.execSQL(ctq);
			Toast.makeText(this, "Table is created!!", 1000).show();
			break;
			
		case R.id.dbb2 :
			//Load data
			int []rn = {101,102,103,104};
			String []n ={"mukesh","vikram","vijay","ritesh"};
			String []dt = {"cse","ece","mech","prod"};
			for(int i =0;i<rn.length;i++)
			{
			String isd = "insert into emp values("+rn[i]+",'"+n[i]+"','"+dt[i]+"');";
			db.execSQL(isd);
			}
			Toast.makeText(this, "Data is Loaded!!", 1000).show();
			break;
			
		case R.id.dbb3 :
			//view Data
			String q = "select * from emp";
			Cursor c = db.rawQuery(q,null);
			if(c.moveToNext()==true)
			{
				Intent i = new Intent(EmployeeDatabase.this,DatabaseView.class);
				i.putExtra("ename", c.getString(0));
				i.putExtra("eage", c.getString(1));
				i.putExtra("edept", c.getString(2));
				startActivity(i);
			}
			else
			Toast.makeText(this, "Data Not Available" , Toast.LENGTH_LONG).show();
			break;
		
		}
	}
}
