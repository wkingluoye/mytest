package hztg.king.test02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import util.CounterService;
import util.ICounterService;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.app.Notification;

public class sixthActivaty extends Activity implements OnClickListener {
	private final static String LOG_TAG = "broadcast.sixthActivaty";

	private Button startButton = null;
	private Button stopButton = null;
	private TextView counterText = null;
	private Button btn06_01 = null;
	private Button btn06_02 = null;
	private Button btn06_03 = null;
	private Button btn06_04 = null;
	private RadioButton rbt06_01 = null;
	private RadioButton rbt06_02 = null;
	private RadioButton rbt06_03 = null;
	private RadioButton rbt06_04 = null;
	private Timer mTimer = null;
	private TimerTask mTimerTask = null;
	
	private ICounterService counterService = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixth);

		startButton = (Button) findViewById(R.id.button_start);
		stopButton = (Button) findViewById(R.id.button_stop);
		counterText = (TextView) findViewById(R.id.textview_counter);

		startButton.setOnClickListener(this);
		stopButton.setOnClickListener(this);

		startButton.setEnabled(true);
		stopButton.setEnabled(false);

		Intent bindIntent = new Intent(sixthActivaty.this, CounterService.class);
		bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);

		////////////
		btn06_01 = (Button) findViewById(R.id.btn06_01);
		btn06_02 = (Button) findViewById(R.id.btn06_02);
		btn06_03 = (Button) findViewById(R.id.btn06_03);
		btn06_04 = (Button) findViewById(R.id.btn06_04);
		rbt06_01 = (RadioButton)findViewById(R.id.rbt06_01);
		rbt06_02 = (RadioButton)findViewById(R.id.rbt06_02);
		rbt06_03 = (RadioButton)findViewById(R.id.rbt06_03);
		rbt06_04 = (RadioButton)findViewById(R.id.rbt06_04);
		
		btn06_01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowTime=format.format(new Date());
				showNotice("King", nowTime);
			}
		});
		
		btn06_02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				removeNotice(R.string.app_name);
			}
		});
		btn06_03.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowTime=format.format(new Date());
				showCustomerNotice("King", nowTime);
			}
		});
		
		btn06_04.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				removeNotice(R.string.app_name+2);
			}
		});
		
	}
	private void showNotice(String contentTitle,String contentText) {
		Log.i("showNotice","����֪ͨ��");
		/* ����֪ͨ�� */
		//����һ��NotificationManager������
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//��ʼ��Notification�ĸ�������(֪ͨͼ��,֪ͨ�ı�,֪ͨ�����ʱ��)
		int imgFlag=(rbt06_01.isChecked())? R.drawable.ic_launcher :R.drawable.ic_launcher2 ;
		//Log.i("King","ͼ��:"+imgFlag);
		
		Notification n = new Notification(imgFlag, "King,"+contentText+"!",System.currentTimeMillis());
		/*
		* �������
		* notification.defaults |=Notification.DEFAULT_SOUND;
		* ����ʹ�����¼��ַ�ʽ
		* notification.sound = Uri.parse("file:///sdcard/notification/ringer.mp3");
		* notification.sound = Uri.withAppendsksedPath(Audio.Media.INTERNAL_CONTENT_URI, "6");
		* �����Ҫ�����������ظ�ֱ���û���֪ͨ������Ӧ���������notification��flags�ֶ�����"FLAG_INSISTENT"
		* ���notification��defaults�ֶΰ�����"DEFAULT_SOUND"���ԣ���������Խ�����sound�ֶ��ж��������
		*/
		//n.defaults  |=Notification.DEFAULT_SOUND;
		/*
		* �����
		* notification.defaults |= Notification.DEFAULT_VIBRATE;
		* ���߿��Զ����Լ�����ģʽ��
		* long[] vibrate = {0,100,200,300}; //0�����ʼ�񶯣���100�����ֹͣ���ٹ�200������ٴ���300����
		* notification.vibrate = vibrate;
		* long������Զ������Ҫ���κγ���
		* ���notification��defaults�ֶΰ�����"DEFAULT_VIBRATE",��������Խ�����vibrate�ֶ��ж������
		*/
		//n.defaults  |=Notification.DEFAULT_VIBRATE;
		/*
		* ���LED������
		* notification.defaults |= Notification.DEFAULT_LIGHTS;
		* ���߿����Լ���LED����ģʽ:
		* notification.ledARGB = 0xff00ff00;
		* notification.ledOnMS = 300; //����ʱ��
		* notification.ledOffMS = 1000; //���ʱ��
		* notification.flags |= Notification.FLAG_SHOW_LIGHTS;
		*/
		//n.defaults  |=Notification.DEFAULT_LIGHTS;
		/*
		* ������������
		* notification.flags |= Notification.FLAG_AUTO_CANCEL; //��֪ͨ���ϵ����֪ͨ���Զ�����֪ͨ
		* notification.flags |= FLAG_INSISTENT; //�ظ�����������ֱ���û���Ӧ��֪ͨ
		* notification.flags |= FLAG_ONGOING_EVENT; //����֪ͨ�ŵ�֪ͨ����"Ongoing"��"��������"����
		* notification.flags |= FLAG_NO_CLEAR; //�����ڵ����֪ͨ���е�"���֪ͨ"�󣬴�֪ͨ�����
		* //������FLAG_ONGOING_EVENTһ��ʹ��
		* notification.number = 1; //number�ֶα�ʾ��֪ͨ���ĵ�ǰ�¼������������״̬��ͼ��Ķ���
		* //���Ҫʹ�ô��ֶΣ������1��ʼ
		* notification.iconLevel = ; //
		*/
		n.flags = Notification.FLAG_AUTO_CANCEL;
		if(rbt06_04.isChecked()) n.flags|= Notification.FLAG_ONGOING_EVENT;
		Intent i = new Intent(sixthActivaty.this, seventhActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
		
		// PendingIntent
		PendingIntent contentIntent = PendingIntent.getActivity(sixthActivaty.this,R.string.app_name, i, PendingIntent.FLAG_UPDATE_CURRENT);
		//����֪ͨ���¼���Ϣ	
		n.setLatestEventInfo(sixthActivaty.this, contentTitle, contentText, contentIntent);
		//��Notification���ݸ� NotificationManager
		nm.notify(R.string.app_name, n);
	}
	public void showCustomerNotice(String contentTitle,String contentText){
		Log.i("showCustomerNotice","����֪ͨ��");
		/* ����֪ͨ�� */
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		int imgFlag=(rbt06_01.isChecked())? R.drawable.ic_launcher :R.drawable.ic_launcher2 ;
		int imgFlag2 = (rbt06_01.isChecked())? R.drawable.ic_launcher2 :R.drawable.ic_launcher ;
		
		Notification n = new Notification(imgFlag, "King,"+contentText+"!",System.currentTimeMillis());
		
		RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.noticeview);
		contentView.setImageViewResource(R.id.noticImage, imgFlag2);
		contentView.setTextViewText(R.id.noticTitle, contentTitle);
		contentView.setTextViewText(R.id.noticText, contentText);
		n.contentView = contentView;
		
		n.flags = Notification.FLAG_AUTO_CANCEL;
		if(rbt06_04.isChecked()) n.flags|= Notification.FLAG_ONGOING_EVENT;
		
		Intent i = new Intent(sixthActivaty.this, KingTest.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
		
		// PendingIntent
		PendingIntent contentIntent = PendingIntent.getActivity(sixthActivaty.this,R.string.app_name, i, PendingIntent.FLAG_UPDATE_CURRENT);
		n.contentIntent  = contentIntent;
		
		nm.notify(R.string.app_name+2, n);
	}
	public void removeNotice(int appID){
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		nm.cancel(appID);
	}
	@Override
	public void onResume() {
		super.onResume();

		IntentFilter counterActionFilter = new IntentFilter(
				CounterService.BROADCAST_COUNTER_ACTION);
		registerReceiver(counterActionReceiver, counterActionFilter);
	}

	@Override
	public void onPause() {
		super.onPause();
		unregisterReceiver(counterActionReceiver);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unbindService(serviceConnection);
		removeNotice(R.string.app_name);
		removeNotice(R.string.app_name+2);
	}

	@Override
	public void onClick(View v) {
		if (v.equals(startButton)) {
			if (counterService != null) {
				counterService.startCounter(0);

				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				Log.i(LOG_TAG, "counterService Is start");
			} else {
				Log.i(LOG_TAG, "counterService Is Null");
			}
		} else if (v.equals(stopButton)) {
			if (counterService != null) {
				counterService.stopCounter();

				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		}
	}

	private BroadcastReceiver counterActionReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			int counter = intent.getIntExtra(CounterService.COUNTER_VALUE, 0);
			String text = String.valueOf(counter);
			counterText.setText(text);
			//showNotice();
			Log.i(LOG_TAG, "Receive counter event");
		}
	};

	private ServiceConnection serviceConnection = new ServiceConnection() {
		public void onServiceConnected(ComponentName className, IBinder service) {
			counterService = ((CounterService.CounterBinder) service).getService();
			
			Log.i(LOG_TAG, "Counter Service Connected");
		}

		public void onServiceDisconnected(ComponentName className) {
			counterService = null;
			Log.i(LOG_TAG, "Counter Service Disconnected");
		}
	};

}
