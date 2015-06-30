package com.example.classwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyphoneReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
		if(bundle!=null)
		{
			String state = bundle.getString(TelephonyManager.EXTRA_STATE);
			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
			{
				String mn;
				mn = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Toast.makeText(context, mn, Toast.LENGTH_LONG).show();
			}
		}
	}

}
