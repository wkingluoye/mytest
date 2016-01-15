package hztg.king.test02;

import java.text.SimpleDateFormat;
import java.util.Date;

import util.TestAlarmReceiver02;
import util.mainAlarmReceiver;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seventhActivity extends Activity{
	private Button startButton = null;
	private Button stopButton = null;
	private Button sendButton01  = null;
	private Button sendButton02  = null;
	private Button alarmStartButton = null;
	private Button alarmStopButton = null;
	private Button alarmTopStartButton = null;
	private Button alarmTopStopButton = null;
	private Button setSumButton = null;
	private static TextView showText,sumText;
	public final static String BROADCAST_TEST_ACTION01 = "broadcast.TEST_ACTION01";
	public final static String SEND_VALUE01 = "SEND_VALUE01";
	public final static String BROADCAST_TEST_ACTION02 = "broadcast.TEST_ACTION02";
	public final static String SEND_VALUE02 = "SEND_VALUE02";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seventh);
		
		startButton  = (Button)findViewById(R.id.btn07_start);
		stopButton  = (Button)findViewById(R.id.btn07_stop);
		sendButton01  = (Button)findViewById(R.id.btn07_send01);
		sendButton02  = (Button)findViewById(R.id.btn07_send02);
		showText = (TextView) findViewById(R.id.txt07_show);
		alarmStartButton  = (Button)findViewById(R.id.btn07_ALARM_start);
		alarmStopButton  = (Button)findViewById(R.id.btn07_ALARM_stop);
		
		alarmTopStartButton  = (Button)findViewById(R.id.btn07_ALARM_top_start);
		alarmTopStopButton  = (Button)findViewById(R.id.btn07_ALARM_top_stop);
		
		setSumButton = (Button)findViewById(R.id.btn07_set_sum);
		sumText = (TextView) findViewById(R.id.txt07_set_sum);
		
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		alarmStartButton.setEnabled(true);
		alarmStopButton.setEnabled(false);
		//sendButton.setEnabled(false);
		
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				IntentFilter counterActionFilter = new IntentFilter(BROADCAST_TEST_ACTION01);
				registerReceiver(testReceiver01, counterActionFilter);
				Log.i("King", "testReceiver01 start");
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				//sendButton.setEnabled(true);
			}
		});
		stopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unregisterReceiver(testReceiver01);
				Log.i("King", "testReceiver01 stop");
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				//sendButton.setEnabled(false);
			}
		});
		sendButton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowTime=format.format(new Date());
				Intent intent = new Intent(BROADCAST_TEST_ACTION01);
				intent.putExtra(SEND_VALUE01, nowTime);
				sendBroadcast(intent);
			}
		});
		sendButton02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowTime=format.format(new Date());
				Intent intent = new Intent(BROADCAST_TEST_ACTION02);
				intent.putExtra(SEND_VALUE02, nowTime);
				sendBroadcast(intent);
			}
		});
		
		///////////////
		
		alarmStartButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.cancel(PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this,TestAlarmReceiver02.class), PendingIntent.FLAG_CANCEL_CURRENT));
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, 
					 PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this, TestAlarmReceiver02.class), PendingIntent.FLAG_CANCEL_CURRENT)
					);
				/*
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TestAlarmReceiver.ALARM_SERVICE_INTERVAL, 
					 PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this, TestAlarmReceiver.class), 0)
					);
					*/
				alarmStartButton.setEnabled(false);
				alarmStopButton.setEnabled(true);
			}
		});
		
		alarmStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.cancel(PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this,TestAlarmReceiver02.class), PendingIntent.FLAG_CANCEL_CURRENT));
				
				alarmStartButton.setEnabled(true);
				//alarmStopButton.setEnabled(false);
			}
		});
		
		
		alarmTopStartButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("alarmTopStartButton");
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.cancel(PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this,mainAlarmReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT));
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, 
					 PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this, mainAlarmReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT)
					);
				/*
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TestAlarmReceiver.ALARM_SERVICE_INTERVAL, 
					 PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this, TestAlarmReceiver.class), 0)
					);
					*/
				//alarmStartButton.setEnabled(false);
				//alarmStopButton.setEnabled(true);
				
				System.out.println("mainAlarmReceiver Start:");
			}
		});
		
		alarmTopStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((AlarmManager)getSystemService(Context.ALARM_SERVICE))
				.cancel(PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this,mainAlarmReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT));
				//alarmStartButton.setEnabled(true);
				//alarmStopButton.setEnabled(false);
				System.out.println("mainAlarmReceiver Stop:");
			}
		});
		
		setSumButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainAlarmReceiver.COUNT_SUM = Integer.parseInt(sumText.getText().toString());
				System.out.println("setSumButton :");
				
			}
		});
	}
	public static TextView getShowText() {
		return showText;
	}
	
	private BroadcastReceiver testReceiver01 = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String text = intent.getStringExtra(SEND_VALUE01);
			showText.setText("Receiver01:"+text);

			Log.i("King", "testReceiver01 event");
		}
	};
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		((AlarmManager)getSystemService(Context.ALARM_SERVICE))
		.cancel(PendingIntent.getBroadcast(seventhActivity.this, 0, new Intent(seventhActivity.this,TestAlarmReceiver02.class), PendingIntent.FLAG_CANCEL_CURRENT));
	}


}
