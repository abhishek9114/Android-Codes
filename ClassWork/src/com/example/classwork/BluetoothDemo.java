package com.example.classwork;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BluetoothDemo extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth_demo);
		tv =  (TextView) findViewById(R.id.btstatus);
		BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
		if(ba!=null)
		{
			if(ba.isEnabled())
			{
				//String mydeviseaddress = bluetooth.getAddress();
				//bluetooth.getName();                                                                                                                                                                     
				tv.setText("ONN");
			}
			else
			{
				tv.setText("OFF");
			}
		}else
		{
			tv.setText("No adapter Available");
		}
	}
}
