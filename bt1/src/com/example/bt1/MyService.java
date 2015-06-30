package com.example.bt1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{
	MediaPlayer ourSong;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();	
		Toast.makeText(this,"SERVICE ON CREATE", 1000).show();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
  @Override
public int onStartCommand(Intent intent, int flags, int startId) {
	// TODO Auto-generated method stub
	  Toast.makeText(this,"SERVICE ON START", 1000).show();
	  ourSong = MediaPlayer.create(MyService.this, R.raw.splash_sound);
		ourSong.start();
	return super.onStartCommand(intent, flags, startId);
}	
  @Override
public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Toast.makeText(this,"SERVICE ON DESTROY", 1000).show();
	ourSong.release();
}
 
}
