package com.example.bt1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MusicPlayer extends Activity implements OnClickListener, OnCompletionListener {
	Button b1, b2, b3;
	TextView tv1, tv2;
	 static MediaPlayer mysong = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_player);
		if(mysong==null)
		mysong = MediaPlayer.create(this, R.raw.splash_sound);
		b1 = (Button) findViewById(R.id.ppb);
		b2 = (Button) findViewById(R.id.ffb);
		b3 = (Button) findViewById(R.id.cdb);
		tv1 = (TextView) findViewById(R.id.cdtv);
		tv2 = (TextView) findViewById(R.id.tdtv);
		long duration = mysong.getDuration();
		long dis = duration / 1000;
		long tm = dis / 60;
		long rt = dis % 60;
		String durationToDisp = tm + " : " + rt;
		String p = "Total Duration : "+ durationToDisp;
		tv2.setText(p);
		b1.setBackgroundResource(android.R.drawable.ic_media_play);
		b2.setBackgroundResource(android.R.drawable.ic_media_ff);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		if (mysong.isPlaying() == false)
		{
		b1.setText("Play");
		b1.setBackgroundResource(android.R.drawable.ic_media_play);
		}
		else
		{
			b1.setText("Pause");
			b1.setBackgroundResource(android.R.drawable.ic_media_pause);
		}
		mysong.setOnCompletionListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ppb:
			String s1 = b1.getText().toString();
				if (mysong.isPlaying() == false)
				{
					mysong.start();
					//if (s1.equals("Play"))
				b1.setText("Pause");
				b1.setBackgroundResource(android.R.drawable.ic_media_pause);
				}
				
		else {
				if (mysong.isPlaying() == true)
					mysong.pause();
				b1.setBackgroundResource(android.R.drawable.ic_media_play);
				b1.setText("Play");
			}
			break;
		case R.id.ffb:
			long cd = mysong.getCurrentPosition();
			long np = cd + 5000;
			if (np < mysong.getDuration())
				mysong.seekTo((int) cd + 5000);
			break;
		case R.id.cdb:
			long duration = mysong.getCurrentPosition();
			long dis = duration / 1000;
			long tm = dis / 60;
			long rt = dis % 60;
			String durationToDisp = tm + " : " + rt;
			String p1 = "CurrentDuration : " + durationToDisp;
			tv1.setText(p1);
			break;

		}

	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		mysong = MediaPlayer.create(this, R.raw.splash_sound2);
		long duration = mysong.getDuration();
		long dis = duration / 1000;
		long tm = dis / 60;
		long rt = dis % 60;
		String durationToDisp = tm + " : " + rt;
		String p = "Total Duration : "+ durationToDisp;
		tv2.setText(p);
		long duration1 = mysong.getCurrentPosition();
		long dis1 = duration1 / 1000;
		long tm1 = dis1 / 60;
		long rt1 = dis1 % 60;
		String durationToDisp1 = tm1 + " : " + rt1;
		String p1 = "CurrentDuration : " + durationToDisp1;
		tv1.setText(p1);
		mysong.start();
	}
}
