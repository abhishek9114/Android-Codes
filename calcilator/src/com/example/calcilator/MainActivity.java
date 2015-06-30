package com.example.calcilator;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	float op1 = 0f, op2 = 0f, answer = 0f;
	int continousentry = 1;
	String full = "";
	int operator = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void appenddata(String string) {
		// TODO Auto-generated method stub
		EditText etext = (EditText) findViewById(R.id.etext);
		if (this.continousentry == 1) {
			this.continousentry = 0;
			etext.setText("");
		}
		etext.append(string);
	}

	public void appendoperator(String sign) {
		EditText etext = (EditText) findViewById(R.id.etext);
		this.operator = 1;
		this.continousentry = 1;
		try
		{
		if (etext.getText().toString().equals(".")) {
			etext.setText("0");
		}
		if (etext.getText().toString().length() > 0) {
			op1 = Float.parseFloat(etext.getText().toString());
		}
		if (sign.equals("+"))
			full = "+";
		else if (sign.equals("-"))
			full = "-";
		else if (sign.equals("*"))
			full = "*";
		else if (sign.equals("/"))
			full = "/";
		else if (sign.equals("%"))
			full = "%";
		else if (sign.equals("root")) {
			answer = (float) Math.sqrt(Float.parseFloat(etext.getText().toString()));
			etext.setText(answer + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		} else if (sign.equals("square")) {
			float z = (Float) (Float.parseFloat(etext.getText().toString()));
			answer = z * z;
			etext.setText(answer + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		} else if (sign.equals("cube")) {
			float z = (Float) (Float.parseFloat(etext.getText().toString()));
			answer = z * z * z;
			etext.setText(answer + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		else if(sign.equals("sin"))
		{
			double z = (Double.parseDouble(etext.getText().toString()));
			etext.setText(Math.sin(Math.toRadians(z)) + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;	
		}
		else if(sign.equals("cos"))
		{
			double z = (Double.parseDouble(etext.getText().toString()));
			etext.setText(Math.cos(Math.toRadians(z)) + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;	
		}
		else if(sign.equals("tan"))
		{
			double z = (Double.parseDouble(etext.getText().toString()));
			etext.setText(Math.tan(Math.toRadians(z)) + "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		else if(sign.equals("dec"))
		{
			float f1 = Float.parseFloat(etext.getText().toString());
			etext.setText(f1+ "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		else if(sign.equals("bin"))
		{
			
			int bn = (int)Float.parseFloat(etext.getText().toString());
			etext.setText(Integer.toBinaryString(bn)+ "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		else if(sign.equals("hex"))
		{
			int bn = (int)Float.parseFloat(etext.getText().toString());
			etext.setText(Integer.toHexString(bn)+ "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		else if(sign.equals("oct"))
		{

			int bn = (int)Float.parseFloat(etext.getText().toString());
			etext.setText(Integer.toOctalString(bn)+ "");
			op1 = 0f;
			op2 = 0f;
			continousentry = 1;
			full = "";
			answer = 0f;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			etext.setText("Invalid Operation");
		}
		finally
		{
			//hi exception
		}
	}

	public void calculate() {
		EditText etext = (EditText) findViewById(R.id.etext);
		try
		{
		int p = 0;
		if (etext.getText().toString().equals(".")) {
			etext.setText("0");
		}
		if (etext.getText().toString().length() > 0)
			op2 = Float.parseFloat(etext.getText().toString());
		if (full.equals("+"))
			answer = op1 + op2;
		if (full.equals("-"))
			answer = op1 - op2;
		if (full.equals("*"))
			answer = op1 * op2;
		if (full.equals("/")) {
			if (!(op2 == 0f))
				answer = op1 / op2;
			else	p = 1;

		}
		if (full.equals("%"))
			answer = op1 % op2;
		if (p == 1)
			etext.setText("Infinity" + "");
		else {
			etext.setText(answer + "");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			etext.setText("Invalid operation");
		}
		finally
		{
			//hi exception catched;
		}
	}

	public void ClickHandler(View v) {
		EditText etext = (EditText) findViewById(R.id.etext);
		switch (v.getId()) {
		case R.id.button0:
			appenddata("0");
			break;
		case R.id.button1:
			appenddata("1");
			break;
		case R.id.button2:
			appenddata("2");
			break;
		case R.id.button3:
			appenddata("3");
			break;
		case R.id.button4:
			appenddata("4");
			break;
		case R.id.button5:
			appenddata("5");
			break;
		case R.id.button6:
			appenddata("6");
			break;
		case R.id.button7:
			appenddata("7");
			break;
		case R.id.button8:
			appenddata("8");
			break;
		case R.id.button9:
			appenddata("9");
			break;
		case R.id.buttonplus:
			appendoperator("+");
			break;
		case R.id.buttonminus:
			appendoperator("-");
			break;
		case R.id.buttonmultiply:
			appendoperator("*");
			break;
		case R.id.buttondivide:
			appendoperator("/");
			break;
		case R.id.buttonequal:
			if(etext.getText().toString().length()>0 && full!="")
				calculate();
			continousentry=1;
			full="";
			op1=0f;
			op2=0f;
			answer=0f;
			operator=0;
			break;
		case R.id.buttonexit:
			Toast.makeText(this, "It's Over Man", 1000).show();
			finish();
			break;
		case R.id.buttonreset:
			continousentry=1;
			full="";
			op1=0f;
			op2=0f;
			answer=0f;
			operator=0;
			etext.setText("0");
			break;
		case R.id.buttonmodulo:
			appendoperator("%");
			break;
		case R.id.buttonsin:
			appendoperator("sin");
			break;
		case R.id.buttoncos:
			appendoperator("cos");
			break;
		case R.id.buttontan:
			appendoperator("tan");
			break;
		case R.id.buttonbin:
			appendoperator("bin");
			break;
		case R.id.buttonhex:
			appendoperator("hex");
			break;
		case R.id.buttondec:
			appendoperator("dec");
			break;
		case R.id.buttonoct:
			appendoperator("oct");
			break;
		case R.id.buttonpi:
			appenddata("3.14159265359");
			break;
		case R.id.buttonsquare:
			appendoperator("square");
			break;
		case R.id.buttoncube:
			appendoperator("cube");
			break;
		case R.id.buttonroot:
			appendoperator("root");
			break;
		case R.id.buttondot:
			if(!(etext.getText().toString().contains(".")))
			appenddata(".");
			break;
		}

	}
}
