package com.example.pptoy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class HomeActivity extends Activity {

	private EditText name,pwd;
	private Button mbut1,mbut2;
	private CheckBox mcb1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		this.name=(EditText)super.findViewById(R.id.ex1);
		this.pwd=(EditText)super.findViewById(R.id.ex2);
		this.mbut1=(Button)super.findViewById(R.id.bu1);
		this.mbut2=(Button)super.findViewById(R.id.bu2);
		this.mcb1=(CheckBox)super.findViewById(R.id.cb1);
		mbut1.setOnClickListener(new ShowListenerone());
		mbut2.setOnClickListener(new ShowListenertwo());
		mcb1.setOnClickListener(new showCheckBox());
		}

	
	public class ShowListenerone implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String msg1=name.getText().toString();
			String msg2=pwd.getText().toString();
			if(msg1.equals("admin")&&msg2.equals("123"))
			{
				Toast.makeText(HomeActivity.this, "登陆成功",Toast.LENGTH_SHORT).show();;
				Intent i=new Intent();
				i.setClass(HomeActivity.this,ChoseActivity.class);
				startActivity(i);
			}
			else
			{
				Toast.makeText(HomeActivity.this, "登陆失败",Toast.LENGTH_SHORT).show();;
			}
			
		}
		
	}
	private class ShowListenertwo implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			name.setText("");
			pwd.setText("");
		}
		
	}
//复选框被选中，则文本框内容可见；否则文本框内容不可见
	private class showCheckBox implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mcb1.isChecked()){     
				HomeActivity.this.pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			}
			else{
				HomeActivity.this.pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
			}
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
