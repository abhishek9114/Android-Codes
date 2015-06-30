package com.example.bt1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MediaClassAssignment extends Activity implements OnSeekBarChangeListener {

	ProgressBar pb;
	TextView tv;
	MediaPlayer song;
	SeekBar sb;
	 long j,p,k,l;
	 int i=0;
	 long cp ;
	 long  check,prg;
	 long currentpos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		song = MediaPlayer.create(MediaClassAssignment.this, R.raw.splash_sound);
		setContentView(R.layout.activity_media_class_assignment);
		pb = (ProgressBar) findViewById(R.id.progressBar);
		tv = (TextView) findViewById(R.id.textview);
		sb = (SeekBar) findViewById  (R.id.seekBar);
		sb.setOnSeekBarChangeListener(this);
		 j = song.getDuration();
		 pb.setMax((int)j);
		 sb.setMax((int)j);
		 p = j/100;
		 k=1;
		 l=1;
		song.start();
		cp = song.getCurrentPosition();
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
					if(check == 1)
					{
						currentpos = song.getCurrentPosition();
						song.seekTo((int)currentpos+(int) prg);
						check =0;
					}
				try {
					sleep(1000);
					currentpos = song.getCurrentPosition();
					pb.setProgress((int)currentpos);
					sb.setProgress((int)currentpos);
					cp = song.getCurrentPosition();
					
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
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		if(fromUser){
		song.seekTo(sb.getProgress());
		}
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
