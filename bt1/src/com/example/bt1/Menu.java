package com.example.bt1;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity","Testing", "Textgame", "Email", "Camera","MediaClassAssignment", "Assignment_class", "ClassMenu", "Data","exit",
			"Temperature_Convereter", "MusicPlayer", "ServiceDemo","Jumble_assignment","ToggleButtonDemo","SeekBarDemo","ProgressBarDemo","ACTextDemo","LayoutMenu","LoginAndTest"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//fullScreen Code
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try {
			Class ourClass = Class.forName("com.example.bt1." + cheese);
			String p = ourClass.toString();
			Intent ourIntent = new Intent(Menu.this, ourClass);
			if(p.equals("com.example.bt1.exit"))
			{
				AlertDialog.Builder b = new AlertDialog.Builder(this);
				b.setTitle("Close Appliction");
				b.setIcon(R.drawable.koala);
				b.setMessage("Are You Sure To Close..??");
				b.setPositiveButton("Yes", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						finish();
					}
				});
				b.setNegativeButton("No", null);
				b.setCancelable(false);
				AlertDialog confirm = b.create();
				confirm.show();
			}
			else
			{
			startActivity(ourIntent);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.cool_menu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.aboutUs:
			Intent i = new Intent("com.example.bt1.ABOUTUS");
			startActivity(i);
			break;

		case R.id.preferences:
			Intent p = new Intent("com.example.bt1.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}

}
