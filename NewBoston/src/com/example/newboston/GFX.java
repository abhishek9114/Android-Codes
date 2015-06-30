package com.example.newboston;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Menu;
import android.view.MenuItem;

public class GFX extends Activity {

	MyBringBack ourView;
	WakeLock wl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//WakeLock
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Whatever");
		super.onCreate(savedInstanceState);
		wl.acquire();
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}
}
