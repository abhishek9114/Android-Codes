package com.example.bt1;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TransferDataIntent extends Activity {
 TextView tname,temail;
 Button val,reg;
 EditText ename,eemail;
 String name ="";
 String email= "";
 final int VAL_REQ_CODE = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transfer_data_intent);
		val= (Button)findViewById(R.id.bsubmit);
		reg=(Button)findViewById(R.id.button1);
		ename = (EditText)findViewById(R.id.etname);
		eemail = (EditText)findViewById(R.id.editText1);
		reg.setEnabled(false);
		SharedPreferences pref = getSharedPreferences("STP15",0);
		String pd = pref.getString("x","");
		ename.setText(pd);
		
		val.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = ename.getText().toString();
				email = eemail.getText().toString();
				Intent i = new Intent(TransferDataIntent.this,TransferedDataIntent.class);
				i.putExtra("data_name", name);
				i.putExtra("data_email", email);
				startActivityForResult(i, VAL_REQ_CODE );
				
			}
		});
		
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b = data.getExtras();
		String rs = b.getString("resp");
		if(rs.equals("Ok")){
			Toast.makeText(this, "DATA IS OK", 1000).show();
			reg.setEnabled(true);
			
		}
		else if(rs.equals("NOT OK")){
			Toast.makeText(this, "DATA IS NOT OK", 1000).show();
			reg.setEnabled(false);
		}
		else{
			Toast.makeText(this, "NO RESPONSE", 1000).show();
			
		}
	}
	@Override
		protected void onStop() {
			// TODO Auto-generated method stub
		String name =  ename.getText().toString();
		SharedPreferences pref = getSharedPreferences("STP15", 0);
		SharedPreferences.Editor e = pref.edit();
		e.putString("x", name);
		e.commit();
			super.onStop();
		}
	}

