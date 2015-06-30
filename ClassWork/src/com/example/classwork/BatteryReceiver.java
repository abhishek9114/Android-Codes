package com.example.classwork;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		Bundle data = arg1.getExtras();
		String s,p;
		if(data!=null)
		{
		s= data.getString(BatteryManager.BATTERY_STATUS);
		p= data.getString(BatteryManager.BATTERY_LEVEL);
		String msg  = "Battery Broadcast :  \n";
		msg += "Battery Status :" +s +"\n";
		msg +=  "Battery Level:" +p +"\n";
		Toast.makeText(context , msg,1000).show();
		Intent i =  new Intent(context,Alone.class);
		i.putExtra("bs", msg);
		PendingIntent pi = PendingIntent.getActivity(context, 0, i,0);
		Notification.Builder b = new Notification.Builder(context);
		b.setContentTitle("Battery Status");
		b.setContentText("Battery is Low");
		b.setSmallIcon(android.R.drawable.ic_lock_idle_low_battery);
		b.setContentIntent(pi);
		Notification noti = b.build();
		NotificationManager nm = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
		//set flags
	  nm.notify(0, noti);
		}
		else
			Toast.makeText(context , "Receiver Activated",1000).show();
		
	}

}
