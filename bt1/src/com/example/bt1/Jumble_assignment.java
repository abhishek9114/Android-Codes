package com.example.bt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Jumble_assignment extends Activity implements OnClickListener{
	String [] ar = {"and","for","try","or","this"};
	Button b1;
	EditText et;
	TextView tv1,tv2;
	static int i,result;
	int j;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jumble_assignment);
		b1 = (Button)   findViewById(R.id.sb);
		et = (EditText) findViewById(R.id.it);
		tv1 = (TextView) findViewById(R.id.rt);
		tv2 = (TextView) findViewById(R.id.jt);
		i=1;
		result=0;
		b1.setOnClickListener(this);
		Random r = new Random();
		Random crazy1 = new Random();
		int  p = crazy1.nextInt(5);
		String ze = ar[p];
		char [] saa ;
		saa = ze.toCharArray();
		for(int o=(ze.length())-1;o>0;o--)
		{
			int rand = r.nextInt(o);
			char temp = saa[o];
			saa[o] = saa[rand];
			saa[rand] = temp;
		}
		ze=String.valueOf(saa);
		tv1.setText(ze);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub	
			String z = et.getText().toString();
			char [] arys = z.toCharArray();
			Arrays.sort(arys);
			String sorted = new String(arys);
			String p1 = tv1.getText().toString();
			char [] arys1 = p1.toCharArray();
			Arrays.sort(arys1);
			String sorted1 = new String(arys1);
			if(sorted.contentEquals(sorted1))
			{
				int check =0;
				for(j=0;j<5;j++)
				{
					if(z.contentEquals(ar[j]))
					{
						check=1;
						break;
					}
				}
				if(check==1)
				{
						result++;
						Toast.makeText(this, "CORRECT!!", 1000).show();
				}
					else
					{
						Toast.makeText(this, "WRONG..", 1000).show();
					}
			}
			i++;
			Random r = new Random();
			Random crazy1 = new Random();
			int  p = crazy1.nextInt(5);
			String ze = ar[p];
			char [] saa ;
			saa = ze.toCharArray();
			for(int o=(ze.length())-1;o>0;o--)
			{
				int rand = r.nextInt(o);
				char temp = saa[o];
				saa[o] = saa[rand];
				saa[rand] = temp;
			}
			ze=String.valueOf(saa);
			tv1.setText(ze);
		if(i>5)
		{
				b1.setEnabled(false);
				String answer = "Result"+result;
				tv2.setText(answer);
		}
		

	}

}
