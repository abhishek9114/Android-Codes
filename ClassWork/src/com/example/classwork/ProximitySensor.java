package com.example.classwork;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ProximitySensor extends Activity implements SensorEventListener {
	ImageView flip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proximity_sensor);
		flip = (ImageView) findViewById(R.id.pdflip);
		SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sm.registerListener(this, s,sm. SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float status = event.values[0];
		if(status == 0)
			flip.setImageResource(R.drawable.koala);
		else
			flip.setImageResource(R.drawable.ic_launcher);
		
	}
}
