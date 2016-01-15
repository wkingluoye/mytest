package hztg.king.test02;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import annotation.Apple;
import annotation.FruitInfoUtil;

public class KingTest extends Activity {

	private Button  myButton01 = null;
	private Button  myButton02 = null;
	private Button  myButton03 = null;
	private Button  myButton04 = null;
	private Button  myButton05 = null;
	private Button  myButton06 = null;
	private Button  myButton07 = null;
	private Button  myButton08 = null;
	private Button  myButton09 = null;
	private Button  myButton10 = null;
	private Button  myButton11 = null;
	private Button  myButton12 = null;
	private Button  myButton13 = null;
	private Button  myButton14 = null;
	private Button  myButton15 = null;
	private Button  myButton16 = null;
	private Button  myButton17 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		TextView myTxView01 = (TextView) findViewById(R.id.txtmain01);
		 myButton01 = (Button) findViewById(R.id.btn01);
		
		myTxView01.setText(" - -!");
		myButton01 .setText("点我呀!");
		myButton01 .setOnClickListener( new btn01Listener());
		
		
		myButton02 = (Button) findViewById(R.id.btn02);
		myButton02 .setText("发信息给我");
		myButton02.setOnClickListener(new btn02Listener());
		
		myButton03 = (Button) findViewById(R.id.btn03);
		myButton03 .setText("简易计算器");
		myButton03.setOnClickListener(new btn03Listener());
		
		myButton04 = (Button) findViewById(R.id.btn04);
		myButton04 .setText(R.string.app_label04);
		myButton04.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, forthActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		
		myButton05 = (Button) findViewById(R.id.btn05);
		myButton05 .setText(R.string.app_label05);
		myButton05.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, fifthActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton06 = (Button) findViewById(R.id.btn06);
		myButton06 .setText(R.string.app_label06);
		myButton06.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, sixthActivaty.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton07 = (Button) findViewById(R.id.btn07);
		myButton07 .setText(R.string.app_label07);
		myButton07.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, seventhActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton08 = (Button) findViewById(R.id.btn08);
		myButton08 .setText(R.string.app_label08);
		myButton08.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, eightActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton09 = (Button) findViewById(R.id.btn09);
		myButton09 .setText(R.string.app_label09);
		myButton09.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, ninthActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton10 = (Button) findViewById(R.id.btn10);
		myButton10 .setText(R.string.app_label10);
		myButton10.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, tenthActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton11 = (Button) findViewById(R.id.btn11);
		myButton11 .setText(R.string.app_label11);
		myButton11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, eleventhActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton12 = (Button) findViewById(R.id.btn12);
		myButton12 .setText(R.string.app_label12);
		myButton12.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, twelfthActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton13 = (Button) findViewById(R.id.btn13);
		myButton13 .setText(R.string.app_label13);
		myButton13.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, thirteenActivity.class);
				KingTest.this.startActivity(myintIntent);
				//KingTest.this.finish();
				//淡入淡出
				//overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);  
				
				//左向右滑入
				//overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right); 
				
				
				/*new Handler().postDelayed(new Runnable() 
				{ 
					@Override 
					public void run() 
					{ 
						Intent mainIntent = new Intent(KingTest.this,thirteenActivity.class); 
						KingTest.this.startActivity(mainIntent); 
						
						
					} 
				},3000); */
			}
		});
		myButton14 = (Button) findViewById(R.id.btn14);
		myButton14 .setText(R.string.app_label14);
		myButton14.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, forteenActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton15 = (Button) findViewById(R.id.btn15);
		myButton15 .setText(R.string.app_label15);
		myButton15.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this, fifteenActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton16 = (Button) findViewById(R.id.btn16);
		myButton16 .setText(R.string.app_label16);
		myButton16.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this,sixteenActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		myButton17 = (Button) findViewById(R.id.btn17);
		myButton17 .setText(R.string.app_label17);
		myButton17.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintIntent  = new Intent();
				myintIntent.setClass(KingTest.this,seventeenActivity.class);
				KingTest.this.startActivity(myintIntent);
			}
		});
		
//		myButton01.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//            	System.out.print("King !");
//            	Intent myintIntent  = new Intent();
//    			myintIntent.setClass(KingTest.this, secondActivity.class);
//    			KingTest.this.startActivity(myintIntent);
//            }
//        });
		/*注解示例*/
		FruitInfoUtil.getFruitInfo(Apple.class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.king_test, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings01:
			setTitle("测试1");
			break;
		case R.id.action_settings02:
			setTitle("测试2");
			break;

		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	class btn01Listener implements View.OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "�����ѽ", Toast.LENGTH_LONG).show();
			Intent myintIntent  = new Intent();
			myintIntent.putExtra("time", "2013-04-17");
			myintIntent.setClass(KingTest.this, secondActivity.class);
			KingTest.this.startActivity(myintIntent);
		}
	}
	class btn02Listener implements View.OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Uri uri = Uri.parse("smsto:13588747917");
			Intent myintIntent  = new Intent(Intent.ACTION_SENDTO,uri);
			myintIntent.putExtra("sms_body", "��Ҷ����");
			startActivity(myintIntent);
		}	
	}
	
	class btn03Listener implements View.OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent myintIntent  = new Intent();
			myintIntent.setClass(KingTest.this, thirdActivity .class);
			KingTest.this.startActivity(myintIntent);
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		System.out.println("1---->onStart");
		super.onStart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		System.out.println("1---->onResume");
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		System.out.println("1---->onPause");
		super.onPause();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		System.out.println("1---->onStop");
		super.onStop();
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		System.out.println("1---->onRestart");
		super.onRestart();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("1---->onDestroy");
		super.onDestroy();
	}

	




}
