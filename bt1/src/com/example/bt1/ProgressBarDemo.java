package com.example.bt1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarDemo extends Activity {
	ProgressBar pb;
	TextView tv;
	MediaPlayer song;
 long j,p,k,l;
 int i=0;
 long currentpos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		song = MediaPlayer.create(ProgressBarDemo.this, R.raw.splash_sound);
		setContentView(R.layout.activity_progress_bar_demo);
		pb = (ProgressBar) findViewById(R.id.progressBar);
		tv = (TextView) findViewById(R.id.textview);
		 j = song.getDuration();
		 pb.setMax((int)j);
		 p = j/100;
		 k=1;
		 l=1;
		song.start();
		Thread t = new Thread(){
			public void run(){
				//Toast.makeText(ProgressBarDemo.this, "Duration", 600).show();
				while(song!=null  && song.getCurrentPosition()<song.getDuration())
				{
					tv.post(new Runnable() {
						
						@Override
						public void run() {
							k=((song.getCurrentPosition()*100)/song.getDuration());
							// TODO Auto-generated method stub
								String z = (k)+"%"+"/"+100;
								if(song==null)
								{
									z = (100)+"%"+"/"+100;
									tv.setText(z);
								}
								tv.setText(z);
								//k++;
						}
					});
				try {
					sleep(1000);
					currentpos = song.getCurrentPosition();
					pb.setProgress((int)currentpos);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					//String z = i+"/"+pb.getMax();
					//tv.setText(z);
				}
				//k++;
				} }

		};
		t.start();
	}

}
