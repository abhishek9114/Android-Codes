package com.example.classwork;

import java.lang.reflect.Field;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MenuDemo extends Activity {
	
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo);
		b1 = (Button)findViewById(R.id.bmdemo);
		registerForContextMenu(b1);
		/*try{
			ViewConfiguration config  = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		if(menuKeyField != null)
		{
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		}
		}
		catch(Exception e)
		{
			
		}*/
		ActionBar ab  = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.show();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.cmi1)
		{
			Toast.makeText(this, "View", 1000).show();
		}
		else if(item.getItemId() == R.id.cmi2)
		{
			Toast.makeText(this, "Share", 1000).show();
		}
		else if(item.getItemId() == R.id.cmi3)
		{
			Toast.makeText(this, "Edit", 1000).show();
		}
		else
		{
			Toast.makeText(this, "Delete", 1000).show();
		}
		return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater i = getMenuInflater();
		i.inflate(R.menu.menu_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if(item.getItemId() == R.id.omi1)
		{
			Toast.makeText(this, "Setting", 1000).show();
		}
		else if(item.getItemId() == R.id.omi2)
		{
			Toast.makeText(this, "Search", 1000).show();
		}
		else if(item.getItemId() == R.id.omi3)
		{
			Toast.makeText(this, "Camera", 1000).show();
		}
		else
		{
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.ctxmenu, menu);
	}
}
