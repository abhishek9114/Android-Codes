package com.example.androiddatabase;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button b1,b2,b3;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
			String ctq = "create table if not exists stud(rollno int(4), sname varchar);";
			db.execSQL(ctq);
			Toast.makeText(this, "Table is created!!", 1000).show();
			break;
			
		case R.id.dbb2 :
			//Load data
			int []rn = {101,102,103,104};
			String []n ={"mukesh","vikram","vijay","ritesh"};
			for(int i =0;i<rn.length;i++)
			{
			String isd = "insert into stud values("+rn[i]+",'"+n[i]+"');";
			db.execSQL(isd);
			}
			Toast.makeText(this, "Data is Loaded!!", 1000).show();
			break;
			
		case R.id.dbb3 :
			//view Data
			//String q = "select * from stud";
			//Cursor c = db.rawQuery(q,null);
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
			break;
		
		}
	}
}
