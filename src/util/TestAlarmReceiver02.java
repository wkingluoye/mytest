package util;

import hztg.king.test02.seventhActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestAlarmReceiver02 extends BroadcastReceiver{
    //alarm service interval
    public static final long ALARM_SERVICE_INTERVAL = 10*1000;//1Сʱ
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=format.format(new Date());
		Intent intentv = new Intent(seventhActivity.BROADCAST_TEST_ACTION01);
		intentv.putExtra(seventhActivity.SEND_VALUE01, nowTime);
		context.sendBroadcast(intentv);
		//seventhActivity.getShowText().setText("TestAlarmReceiver:"+nowTime);
		Log.i("King", "TestAlarmReceiver:"+nowTime + ", currentTimeMillis = " + System.currentTimeMillis());
	}

}
