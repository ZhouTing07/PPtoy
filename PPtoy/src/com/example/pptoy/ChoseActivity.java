package com.example.pptoy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class ChoseActivity extends Activity {
    private ImageButton imbu1,imbu2; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chose);
		this.imbu1=(ImageButton)super.findViewById(R.id.ci1);
		this.imbu2=(ImageButton)super.findViewById(R.id.ci2);
		imbu1.setOnClickListener(new OnClickImageone());
		imbu2.setOnClickListener(new OnClickImagetwo());
}

	public class OnClickImageone implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent();
			i.setClass(ChoseActivity.this,ParentActivity.class);
			startActivity(i);
		}
}
	public class OnClickImagetwo implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent j=new Intent();
			j.setClass(ChoseActivity.this,ChildActivity.class);
			startActivity(j);
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
