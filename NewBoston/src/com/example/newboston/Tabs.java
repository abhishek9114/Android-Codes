package com.example.newboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	TabHost th;
	TextView tv;
	Button newtab,start,stop;
	long starttime,stoptime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
		th = (TabHost) findViewById(R.id.tabhost);
		newtab = (Button) findViewById(R.id.baddtab);
		start  = (Button) findViewById(R.id.bstartwatch);
		stop = (Button) findViewById(R.id.bstopwatch);
		newtab.setOnClickListener(this);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		tv = (TextView) findViewById(R.id.tvshowresults);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Stop watch");
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab2");
		th.addTab(specs);
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);
		starttime = 0;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.baddtab :
			
			TabSpec ourspec = th.newTabSpec("tg");
			ourspec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tabs.this);
					text.setText("You Have created a New Tab..!!");
					return (text);
				}
			});
			ourspec.setIndicator("New One");
			th.addTab(ourspec);
			break;
		case R.id.bstartwatch :
		 starttime = System.currentTimeMillis();
			break;
		case R.id.bstopwatch :
			stoptime = System.currentTimeMillis();
			if(starttime!=0)
			{
				long result = stoptime - starttime;
				int millis = (int) result;
				int seconds = millis/1000;
				int minutes = seconds/60;
				millis = millis%100;
				seconds =seconds%60;
				tv.setText(String.format("%d:%02d%02d", minutes,seconds,millis));
			}
			break;
		}
	}
}
