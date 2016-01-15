package hztg.king.test02;

import hztg.king.test02.R.id;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class thirdActivity extends Activity{
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch (item.getItemId()) {
		case 1:
			System .out.println("退出");
			finish();
			break;
		case 2:
			System .out.println("关于");
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}


	private TextView txt03_1 = null;
	private TextView txt03_2 = null;
	private EditText etxt03_1 = null;
	private EditText etxt03_2 = null;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,1,1,"退出");
		menu.add(0,2,2,"关于");
		return super.onCreateOptionsMenu(menu);
	}


	private Button btn03_1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		txt03_1 = (TextView) findViewById(R.id.txt03_01);
		txt03_1 .setText(R.string.str03);
		
		txt03_2 = (TextView) findViewById(R.id.txt03_02);
		txt03_2 .setText("乘以");
		
		etxt03_1 = (EditText) findViewById(R.id.factor1);
		
		etxt03_2 = (EditText) findViewById(R.id.factor2);
		
		btn03_1 = (Button) findViewById(id.btn03_1);
		btn03_1.setText("计算");
		btn03_1.setOnClickListener(new btn03_1Lister());
		
	}
	
	
	class btn03_1Lister implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String num1 = etxt03_1.getText().toString();
			String num2 = etxt03_2.getText().toString();
			
			Intent myIntent = new Intent();
			myIntent.putExtra("num1", num1);
			myIntent.putExtra("num2", num2);
			
			myIntent.setClass(thirdActivity.this, third_r.class);
			
			thirdActivity.this.startActivity(myIntent);
		}
		
	}
	
}
