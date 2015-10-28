package com.example.pptoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



@SuppressWarnings("deprecation")
public class ZGallery3Activity extends Activity {
	private ImageView im1;
	private Button im2;
	private int screenWidth;
	private int screenHeight;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_z3);
		im1=(ImageView)this.findViewById(R.id.mim1);
		im2=(Button)this.findViewById(R.id.b2);
		DisplayMetrics dm=getResources().getDisplayMetrics();
		screenWidth=dm.widthPixels;
		screenHeight=dm.heightPixels-50;
		im1.setOnTouchListener(movingEventListener);
		im2.setOnClickListener(new ABC());;
}
	public class ABC implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent();
			i.setClass(ZGallery3Activity.this,ChoseActivity.class);
			startActivity(i);
		}
}
    private OnTouchListener movingEventListener = new OnTouchListener() { 
        int lastX, lastY; 
        MediaPlayer mediaplay=null;
 
        public boolean onTouch(View v, MotionEvent event) { 
            switch (event.getAction()) { 
            case MotionEvent.ACTION_DOWN: 
                lastX = (int) event.getRawX(); 
                lastY = (int) event.getRawY(); 
                break; 
            case MotionEvent.ACTION_MOVE: 
                int dx = (int) event.getRawX() - lastX; 
                int dy = (int) event.getRawY() - lastY; 
 
                int left = v.getLeft() + dx; 
                int top = v.getTop() + dy; 
                int right = v.getRight() + dx; 
                int bottom = v.getBottom() + dy; 
                // 设置不能出界 
                if (left < 0) { 
                    left = 0; 
                    right = left + v.getWidth(); 
                } 
 
                if (right > screenWidth) { 
                    right = screenWidth; 
                    left = right - v.getWidth(); 
                } 
 
                if (top < 0) { 
                    top = 0; 
                    bottom = top + v.getHeight(); 
                } 
 
                if (bottom > screenHeight) { 
                    bottom = screenHeight; 
                    top = bottom - v.getHeight(); 
                } 
 
                v.layout(left, top, right, bottom); 
 
                lastX = (int) event.getRawX(); 
                lastY = (int) event.getRawY(); 
                
                if(lastX<=367&&lastY<=367){
                	im1.setVisibility(View.INVISIBLE);
                	mediaplay=MediaPlayer.create(ZGallery3Activity.this, R.raw.happy);
                	mediaplay.start();
                	Intent i=new Intent();
     				i.setClass(ZGallery3Activity.this,ZGallery2Activity.class);
     				startActivity(i);
                	}
                break; 
            case MotionEvent.ACTION_UP: 
                break; 
            } 
            return true; 
        } 
    }; 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
