package hztg.king.test02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends Activity {
	
	private TextView secondTxtVw01 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		secondTxtVw01 = (TextView) findViewById(R.id.txtsec01);
		Intent myIntent = getIntent();
		secondTxtVw01.setText(secondTxtVw01 .getText()+"\n"+myIntent.getStringExtra("time"));
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println("2---->onStart");
		super.onStart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("2---->onResume");
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("2---->onPause");
		super.onPause();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("2---->onStop");
		super.onStop();
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("2---->onRestart");
		super.onRestart();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("2---->onDestroy");
		super.onDestroy();
	}

}
