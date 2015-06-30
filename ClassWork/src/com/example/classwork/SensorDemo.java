package com.example.classwork;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorDemo extends Activity implements SensorEventListener{

	TextView status,effect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_demo);
		status  =(TextView) findViewById(R.id.sdstatus);
		effect = (TextView) findViewById(R.id.sdeffect);
		String ss =  Context.SENSOR_SERVICE;
		SensorManager sm;
		sm = (SensorManager)getSystemService(ss);
		int st  =Sensor.TYPE_ORIENTATION;
		Sensor s = sm.getDefaultSensor(st);
		sm.registerListener(this, s, sm.SENSOR_DELAY_NORMAL);
	//	sm.unregisterListener(this);
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float x = event.values[1];
		float y = event.values[2];
		float z = event.values[0];
		String ts = "STATUS:\nX = "+x+"\nY = "+y+"\nZ = "+z;
		status.setText(ts);
		effect.setBackgroundColor(Color.rgb((int)x, (int)y, (int)z));
	}
}
