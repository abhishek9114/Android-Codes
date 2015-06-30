package com.example.newboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class UserShowData extends Activity implements OnClickListener{

	TextView tv1,tv2,tv3;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usershowdata);
		tv1 = (TextView) findViewById(R.id.tname);
		tv2 = (TextView) findViewById(R.id.temail);
		tv3 = (TextView) findViewById(R.id.tage);
		b1 = (Button) findViewById(R.id.button);
		Intent i = getIntent();
		Bundle b = i.getExtras();
		String s1 = b.getString("ename");
		String s2 = b.getString("eemail");
		String s3 = b.getString("eage");
		tv1.setText(s1);
		tv2.setText(s2);
		tv3.setText(s3);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
		
	}
}
