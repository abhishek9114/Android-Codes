package com.example.newboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserBiodata extends Activity implements OnClickListener{

	EditText et1, et2, et3;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userbiodata);
		et1 = (EditText) findViewById(R.id.etname);
		et2 = (EditText) findViewById(R.id.etemail);
		et3 = (EditText) findViewById(R.id.etage);
		b1 = (Button) findViewById(R.id.button);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(et1.getText().toString().length()>0 && et2.getText().toString().length()>0 && et3.getText().toString().length()>0)
		{
			Intent i = new Intent(UserBiodata.this,UserShowData.class);
			i.putExtra("ename",et1.getText().toString() );
			i.putExtra("eemail",et2.getText().toString());
			i.putExtra("eage", et3.getText().toString());
			startActivity(i);
		}
		else
		{
			Toast.makeText(this, "Fill all fields", 500).show();
		}
		
	}

}
