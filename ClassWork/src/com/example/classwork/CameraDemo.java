package com.example.classwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraDemo extends Activity implements OnClickListener {

	ImageView img;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_demo);
		img = (ImageView) findViewById(R.id.imageView1);
		b1= (Button) findViewById(R.id.camb1);
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String ci = android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
		Intent camera = new Intent(ci);
		startActivityForResult(camera,10);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b = data.getExtras();
		Bitmap bmp = (Bitmap)b.get("data");
		img.setImageBitmap(bmp);
	}
}
