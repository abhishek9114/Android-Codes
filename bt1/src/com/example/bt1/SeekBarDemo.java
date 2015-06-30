package com.example.bt1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarDemo extends Activity implements OnSeekBarChangeListener {
TextView status;
SeekBar sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar_demo);
		status = (TextView) findViewById(R.id.textView4);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setOnSeekBarChangeListener(this);
		//sb.setMax(1000);
		sb.setProgress(10);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		String msg ="STATUS : " + progress;
		status.setText(msg);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"SEEK START", 1000).show();
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"SEEK STOPPED", 1000).show();
		
	}
}
