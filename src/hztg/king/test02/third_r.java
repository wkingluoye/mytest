package hztg.king.test02;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class third_r extends Activity{
	
	private TextView txt03_r1 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_r);
		txt03_r1 = (TextView) findViewById(R.id.txt03_r1);
		Intent myIntent	 = getIntent();
		int num1 =Integer.parseInt(myIntent.getStringExtra("num1")) ;
		int num2 =Integer.parseInt(myIntent.getStringExtra("num2")) ;
		
		int result =  num1 * num2;
		txt03_r1.setText(result+"");
		
	}
	
}
