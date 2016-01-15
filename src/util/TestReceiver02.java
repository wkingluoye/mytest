package util;

import hztg.king.test02.seventhActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class TestReceiver02 extends BroadcastReceiver{
	
	
	public  TestReceiver02() {
		//Log.i("King", "TestReceiver02 Starting");
	}
	public void onReceive(Context context, Intent intent) {
		String text = intent.getStringExtra(seventhActivity.SEND_VALUE02);
		 seventhActivity.getShowText().setText("Receiver02:"+text);
		Log.i("King", "TestAlarmReceiver:"+text);
	}
};