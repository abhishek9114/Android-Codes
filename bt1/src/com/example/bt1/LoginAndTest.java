package com.example.bt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAndTest extends Activity implements OnClickListener{	
String username[] = {"harsh","akash","ankit"};
String Password[] = {"abc","abc","abc"};
	EditText et1,et2;
	Button b1;
	String un,pw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_test);
		et1 = (EditText) findViewById(R.id.usernameet);
		et2 = (EditText) findViewById(R.id.passwordet);
		b1 = (Button) findViewById(R.id.loginsb);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	 un = et1.getText().toString();
	 pw = et2.getText().toString();
	 if(un.contentEquals("")||pw.contentEquals(""))
	 {
		 Toast.makeText(this, "Enter Both field", 1000).show();
	 }
	 else if((un.contentEquals("harsh")&&pw.contentEquals("abc"))||(un.contentEquals("akash")&&pw.contentEquals("abc"))||(un.contentEquals("ankit")&&pw.contentEquals("abc")))
			 {
		     Intent testIntent = new Intent(LoginAndTest.this,TestIntent.class);
		     startActivity(testIntent);
			 }
	 else
	 {
		 Toast.makeText(this, "Enter Correct Credentials", 1000).show();
	 }
	}
}
