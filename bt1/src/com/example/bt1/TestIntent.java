package com.example.bt1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TestIntent extends Activity implements OnClickListener , OnCheckedChangeListener{
	TextView tv1;
    RadioGroup rg1;
    Button b1;
    static int i=0,marks=0;
    String result ;
    int check=0;
	String question[] = {"Cow is Animal..??","Fat Girls Exist..??","Humans Are Immortal..??","There are Schools In a country..??","Tiger Exists..??"};
	String answer[] = {"True","True","False","True","True"};
	String userAnswer[] = {"","","","","","","",""};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_intent);
		tv1 = (TextView) findViewById (R.id.questiontext);
		rg1 = (RadioGroup) findViewById(R.id.radiomain);
		b1 = (Button) findViewById(R.id.sb);
		b1.setOnClickListener(this);
		rg1.setOnCheckedChangeListener(this);
		tv1.setText(question[i]);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(i<question.length)
		{
		if(rg1.getCheckedRadioButtonId()==R.id.radio1)
		{
			if(answer[i].contentEquals("True"))
			{
				marks++;
				Toast.makeText(this, "Correct Answer", 500).show();
				userAnswer[i]="True";
			}
			else
			{
				Toast.makeText(this, "Wrong Answer", 500).show();
				userAnswer[i]="True";
			}
		}
		else
		{
			if(answer[i].contentEquals("True"))
			{
				
				Toast.makeText(this, "Worng Answer", 500).show();
				userAnswer[i]="False";
			}
			else
			{
				marks++;
				Toast.makeText(this, "Correct Answer", 500).show();
				userAnswer[i]="False";
			}
		}
		i++;
		if(i<=4)
		tv1.setText(question[i]);
		if(i==5)
		{
			result = "TestCompleted And Your Marks is : "+marks;
			tv1.setText(result);
			b1.setEnabled(false);
			rg1.clearCheck();
		}
		}
		
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.radio1 :
			check=1;
			break;
		case R.id.radio2:
			check=0;
			break;
		}
	}
}
