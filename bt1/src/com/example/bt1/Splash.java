package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.splash_sound);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if(music == true)
		ourSong.start();
		Thread timer = new Thread()
		{
			public void run()
			{
				try{
					sleep(2000);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					Intent nameOfIntent = new Intent("com.example.bt1.MENU");
					startActivity(nameOfIntent);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
