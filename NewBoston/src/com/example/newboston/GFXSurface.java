package com.example.newboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	MyBringBackSurface ourSurfaceView;
	float x,y,sX,sY,fX,fY,dX,dY,scaledX,scaledY,aniX,aniY;
	Bitmap test,dot;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		x=0;
		y=0;
		sX=0;
		sY=0;
		fX=0;
		fY=0;
		dX=0;
		dY=0;
		scaledX=0;
		scaledY=0;
		aniX=0;
		aniY=0;
	 test =  BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
    dot =  BitmapFactory.decodeResource(getResources(), R.drawable.dot);
		setContentView(ourSurfaceView);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sY = event.getY();
			dX=0;
			dY=0;
			scaledX=0;
			scaledY=0;
			aniX=0;
			aniY=0;
			fX=0;
			fY=0;
			break;

		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX = fX-sX;
			dY = fY-sY;
			scaledX = dX/30;
			scaledY = dY/30;
			x=0;
			y=0;
			break;
		}
		return true;
	}
	public class MyBringBackSurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread;
		boolean isChanging = false;

		public MyBringBackSurface(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			ourHolder = getHolder();

		}

		public void pause() {
			// TODO Auto-generated method stub
			isChanging = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			// TODO Auto-generated method stub
			 isChanging = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isChanging) {
				if (!(ourHolder.getSurface().isValid()))
					continue;
				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(02, 02, 150);
				if(x!=0 && y!=0)
				{
					
					canvas.drawBitmap(test, x-(test.getWidth()/2), y-(test.getHeight()/2), null);
				}
				if(sX!=0 && sY!=0)
				{
					
					canvas.drawBitmap(dot, sX-(dot.getWidth()/2), sY-(dot.getHeight()/2), null);
				}
				if(fX!=0 && fY!=0)
				{
					canvas.drawBitmap(test, fX-(test.getWidth()/2)-aniX, fY-(test.getHeight()/2)-aniY, null);	
					canvas.drawBitmap(dot, fX-(test.getWidth()/2), fY-(dot.getHeight()/2), null);
				}
				aniX = aniX+scaledX;
				aniY = aniY+scaledY;
				ourHolder.unlockCanvasAndPost(canvas);

			}

		}

	}
}
