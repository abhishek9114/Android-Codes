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
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseView extends Activity implements OnClickListener {

	EditText et1,et2,et3;
	Button b1,b2,b3,b4,b5,b6;
	SQLiteDatabase db;
	Cursor c;
	String q;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database_view);
		et1 = (EditText) findViewById(R.id.etname);
		et2 = (EditText) findViewById(R.id.etage);
		et3 = (EditText) findViewById(R.id.etbranch);
		b1 = (Button) findViewById(R.id.bfirst);
		b2 = (Button) findViewById(R.id.bprev);
		b3 = (Button) findViewById(R.id.bnext);
		b4 = (Button) findViewById(R.id.blast);
		b5 =(Button) findViewById(R.id.badd);
		b6 = (Button) findViewById(R.id.bsave);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		Intent i = getIntent();
		Bundle b = i.getExtras();
		et1.setText(b.getString("ename"));
		et2.setText(b.getString("eage"));
		et3.setText(b.getString("edept"));
		et1.setEnabled(false);
		et2.setEnabled(false);
		et3.setEnabled(false);
		b6.setEnabled(false);
		db = openOrCreateDatabase("stp15",MODE_WORLD_READABLE, null );
		 q = "select * from emp";
		 c = db.rawQuery(q,null);
		 if(c.moveToNext())
		 {
			 Toast.makeText(this,"Look at first Data",1000).show();
		 }
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bnext :
			if(c.moveToNext()==true)
			{
			  et1.setText(c.getString(0));
			  et2.setText(c.getString(1));
			  et3.setText(c.getString(2));
			}
			else
			{
				Toast.makeText(this, "Next Data not Available", 1000).show();
				if(c.moveToLast())
				{
					
				}
			}
			break;
		case R.id.bprev :
			if(c.moveToPrevious()==true)
			{
			  et1.setText(c.getString(0));
			  et2.setText(c.getString(1));
			  et3.setText(c.getString(2));
			}
			else
			{
				Toast.makeText(this, "Prev Data not Available", 1000).show();
				if(c.moveToFirst())
				{
					
				}
			}
			break;
		case R.id.bfirst :
			if(c.moveToFirst()==true)
			{
			  et1.setText(c.getString(0));
			  et2.setText(c.getString(1));
			  et3.setText(c.getString(2));
			}
			else
			{
				Toast.makeText(this, "Prev Data not Available", 1000).show();
			}
			break;
		case R.id.blast :
			if(c.moveToLast()==true)
			{
			  et1.setText(c.getString(0));
			  et2.setText(c.getString(1));
			  et3.setText(c.getString(2));
			}
			else
			{
				Toast.makeText(this, "Prev Data not Available", 1000).show();
			}
			break;
		case R.id.badd :
			et1.setEnabled(true);
			et2.setEnabled(true);
			et3.setEnabled(true);
			b6.setEnabled(true);
			b5.setEnabled(false);
			break;
		case R.id.bsave :
			if(et1.getText().toString().length()>0 &&et2.getText().toString().length()>0 &&et3.getText().toString().length()>0)
			{
				int a = Integer.parseInt(et1.getText().toString());
				String s1 = et2.getText().toString();
				String s2 = et3.getText().toString();
			String isd = "insert into emp values("+a+",'"+s1+"','"+s2+"');";
			db.execSQL(isd);
			Toast.makeText(this,"Inserted", 1000).show();
			}
			else
			{
				Toast.makeText(this,"Fill all value", 1000).show();
			}
			et1.setEnabled(false);
			et2.setEnabled(false);
			et3.setEnabled(false);
			b6.setEnabled(false);
			b5.setEnabled(true);
			 c = db.rawQuery(q,null);
			 if(c.moveToFirst())
			 {
				 et1.setText(c.getString(0));
				  et2.setText(c.getString(1));
				  et3.setText(c.getString(2));
			 }
			break;
		}
		
	}
}
