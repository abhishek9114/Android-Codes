package com.example.bt1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TransferedDataIntent extends Activity implements OnClickListener{

	TextView txtname,txtemail,fieldname,fieldemail;
	Button vb,ivb;
	String response= "NO ANSWER";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transfered_data_intent);
		txtname = (TextView)findViewById(R.id.tvstudnamedata);
		txtemail = (TextView)findViewById(R.id.tvstudemaildata);
		fieldname = (TextView)findViewById(R.id.tvstudname);
		fieldemail = (TextView)findViewById(R.id.tvstudemail);
		vb = (Button)findViewById(R.id.button2);
		ivb= (Button)findViewById(R.id.button1);
		vb.setOnClickListener(this);
		ivb.setOnClickListener(this);
		Intent ri = getIntent();
		Bundle b = ri.getExtras();
		String rn = b.getString("data_name");
		String re = b.getString("data_email");
		txtname.setText(""+rn);
		txtemail.setText(""+re);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button2){
			response = "Ok";
			finish();
		}
		else{
			response ="NOT OK";
			finish();
		}
	}
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.putExtra("resp", response);
		setResult(RESULT_OK, i);
		super.finish();
	}
	

	
}
