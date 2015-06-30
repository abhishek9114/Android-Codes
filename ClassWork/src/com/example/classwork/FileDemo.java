package com.example.classwork;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;
import java.util.Map;
public class FileDemo extends Activity implements OnClickListener {

	EditText editor;
	Button read,write;
	String  p;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_demo);
		editor = (EditText) findViewById(R.id.et);
		read = (Button) findViewById(R.id.bt);
		write = (Button) findViewById(R.id.bt1);
		read.setOnClickListener(this);
		write.setOnClickListener(this);
		File root = Environment.getExternalStorageDirectory();
		Map<String, File> externalLocations = ExternalStorage.getAllStorageLocations();
		File sdCard = externalLocations.get(ExternalStorage.SD_CARD);
		File externalSdCard = externalLocations.get(ExternalStorage.EXTERNAL_SD_CARD);
		 p = externalSdCard.getAbsolutePath();
		String path = p +"/splash_sound.mp3";
		Toast.makeText(this, path , Toast.LENGTH_LONG).show();
		mp = new MediaPlayer();
		try
		{
		mp.setDataSource(path);
		mp.prepare();
		mp.start();
		}catch(Exception e)
		{
			String msg = "Not Found";
			Toast.makeText(this, msg, 1000).show();
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bt :
			
			File r = Environment.getExternalStorageDirectory();
			File f = new File(p,"data.txt");
			if(f.exists())
			{
				try {
					FileInputStream fis;
					fis = new FileInputStream(f);
					int a;
					String fd = "";
					while(true)
					{
						a=fis.read();
						if(a==-1)
							break;
						fd = fd+(char)a;
					}
					editor.setText(fd);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
			else
			{
				Toast.makeText(this, "File Not Found", 1000).show();
			}
			break;
		case R.id.bt1 :
			File r1 = Environment.getExternalStorageDirectory();
			File f1 = new File(p,"data.txt");
			try {
				FileOutputStream fos ;
				fos = new FileOutputStream(f1,true);
				String data = editor.getText().toString();
				byte [] content =  data.getBytes();
				fos.write(content);
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}