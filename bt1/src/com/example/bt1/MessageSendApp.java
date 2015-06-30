package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MessageSendApp extends Activity implements OnClickListener{

	EditText et1,et2;
	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_send_app);
		et1 = (EditText) findViewById(R.id.number);
		et2 = (EditText) findViewById(R.id.text);
		b1 = (Button) findViewById(R.id.button);
		b1.setOnClickListener(this);
		b2 = (Button) findViewById(R.id.button1);
		b2.setOnClickListener(this);
		b3 = (Button) findViewById(R.id.button2);
		b3.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button)
		{
		String msg=et2.getText().toString();
		String message = "sms:"+et1.getText().toString();
		Intent i = new Intent(Intent.ACTION_SENDTO,Uri.parse(message));
		//Intent i = new Intent(Intent.ACTION_SEND_MULTIPLE,Uri.parse(message));
		i.putExtra("sms_body", msg);
		startActivity(i);
		}
		else if(v.getId()==R.id.button1)
		{
			//String msg=et2.getText().toString();
			String message = "tel:"+et1.getText().toString();
			Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse(message));
			//i.putExtra("sms_body", msg);
			startActivity(i);
		}
		else
		{
			String message = "http://www.google.com";
			Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(message));
			//i.putExtra("sms_body", msg);
			startActivity(i);
		}
		
	}
}
