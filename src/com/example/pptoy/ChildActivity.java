package com.example.pptoy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class ChildActivity extends Activity {
	private ImageButton i1,i2;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_child);
		this.i1 =(ImageButton)super.findViewById(R.id.cdib1);
		i1.setOnClickListener(new ImageA());
		this.i2 =(ImageButton)super.findViewById(R.id.cdib2);
		i2.setOnClickListener(new ImageB());
		}
public class ImageA implements OnClickListener{
    @Override
	public void onClick(View v) {
	// TODO Auto-generated method stub
		Intent i=new Intent();
		i.setClass(ChildActivity.this,ZGallery1Activity.class);
		startActivity(i);
		}
}
public class ImageB implements OnClickListener{
    @Override
	public void onClick(View v) {
	// TODO Auto-generated method stub
		Intent i=new Intent();
		i.setClass(ChildActivity.this,ZGallery2Activity.class);
		startActivity(i);
		}
}


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
