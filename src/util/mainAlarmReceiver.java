package util;

import hztg.king.test02.seventhActivity;
import hztg.king.test02.suspend2Activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class mainAlarmReceiver extends BroadcastReceiver{
    //alarm service interval
    public static final long ALARM_SERVICE_INTERVAL = 2*1000;//1Сʱ
    public static int COUNT_SUM = 5*12 ; 
    public static int COUNT_I =  0 ;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=format.format(new Date());
		//Intent intentv = new Intent(seventhActivity.BROADCAST_TEST_ACTION01);
		//intentv.putExtra(seventhActivity.SEND_VALUE01, nowTime);
		//context.sendBroadcast(intentv);
		//seventhActivity.getShowText().setText("TestAlarmReceiver:"+nowTime);
		COUNT_I = COUNT_I+1 ; 
		Log.i("King", "COUNT_I:"+COUNT_I + ", COUNT_SUM = " + COUNT_SUM);
		if (COUNT_I >= COUNT_SUM ){
			((AlarmManager)context.getSystemService(Context.ALARM_SERVICE))
			.cancel(PendingIntent.getBroadcast(context, 0, new Intent(context,mainAlarmReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT));
			System.out.println("mainAlarmReceiver Stop: By Self");
			Intent myintIntent  = new Intent();
			myintIntent.setClass(context, suspend2Activity.class);
			myintIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(myintIntent);
		}
		
	}

}
