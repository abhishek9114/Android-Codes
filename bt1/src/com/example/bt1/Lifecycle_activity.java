package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Lifecycle_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lifecycle_activity);
		Toast.makeText(this, "OnCreateCalled", 2000).show();
	}
 	
  @Override
protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	Toast.makeText(this, "OnStartCalled", 2000).show();
}
  @Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	Toast.makeText(this, "OnresumeCalled", 2000).show();

}
  @Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	Toast.makeText(this, "OnStopCalled", 2000).show();
}
  @Override
protected void onRestart() {
	// TODO Auto-generated method stub
	super.onRestart();
	Toast.makeText(this, "OnRestart", 2000).show();
}
 @Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Toast.makeText(this, "OnDestroyCalled", 2000).show();
} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lifecycle_activity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void actionnext(View v)
	{
		Intent i = new Intent(this,Newone.class);
		startActivity(i);
	}
}
