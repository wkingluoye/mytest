package hztg.king.test02;

import service.MsgService;
import service.MsgService.MsgBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class twelfthActivity extends Activity{
	private MsgService bindService  = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twelfth);
		Log.i("twelfthActivity", "onCreate");
		
		Button btnStart = (Button) findViewById(R.id.btn12_start);
		btnStart.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动service 方式1 
				Intent intent = new Intent(twelfthActivity.this,MsgService.class);  
				Log.i("twelfthActivity", "StartService()");
				startService(intent);
				//bindService(intent, conn, Context.BIND_AUTO_CREATE);
				
				//启动service 方式2  
				//Intent intent = new Intent(twelfthActivity.this,MsgService.class);  
				//Log.i("twelfthActivity", "bindService()");  
				//bindService(intent, conn, Context.BIND_AUTO_CREATE); 
			}
		});
		
		
		Button btnStop= (Button) findViewById(R.id.btn12_stop);
		btnStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//停止service 方式1 
				Intent intent = new Intent(twelfthActivity.this,MsgService.class); 
				stopService(intent);
				
				//停止service 方式2  
				//if (bindService!=null){
					//bindService.stopCount();
				//}
				//unbindService(conn);  
			}
		});

		Button btnbind= (Button) findViewById(R.id.btn12_bind);
		btnbind.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动service 方式2  
				Intent intent = new Intent(twelfthActivity.this,MsgService.class);  
				Log.i("twelfthActivity", "bindService()");  
				Boolean bsFlag   = bindService(intent, conn, Context.BIND_AUTO_CREATE);  
				Log.i("twelfthActivity", "bindService Flag:"+bsFlag); 
			}
		});
		
		Button btnunbind= (Button) findViewById(R.id.btn12_unbind);
		btnunbind.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动service 方式2  
				Log.i("twelfthActivity", "unbindService()");  
				//bindService(intent, conn, Context.BIND_AUTO_CREATE);  
				unbindService(conn);
			}
		});
		Button btnsartcount= (Button) findViewById(R.id.btn12_startcount);
		btnsartcount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动service 方式2  
				Log.i("twelfthActivity", "stopCount()");  
				//bindService(intent, conn, Context.BIND_AUTO_CREATE);  
				bindService.startCount();
			}
		});
		Button btnstopcount= (Button) findViewById(R.id.btn12_stopcount);
		btnstopcount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//启动service 方式2  
				Log.i("twelfthActivity", "stopCount()");  
				//bindService(intent, conn, Context.BIND_AUTO_CREATE);  
				bindService.stopCount();
			}
		});
	}

	@Override
	protected void onDestroy() {
		Log.i("twelfthActivity", "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		Log.i("twelfthActivity", "onStart");
		super.onStart();
	}
	private ServiceConnection conn = new ServiceConnection() {  
		         
		        @Override  
		        public void onServiceDisconnected(ComponentName name) {  
		            // TODO Auto-generated method stub  
		            Log.i("twelfthActivity", "onServiceDisconnected()");  
		        }  
		          
		        @Override  
		        public void onServiceConnected(ComponentName name, IBinder service) {  
		            // TODO Auto-generated method stub  
		            Log.i("twelfthActivity", "onServiceConnected()");  
		            MsgBinder binder = (MsgBinder)service;  
		            bindService = binder.getService();  
		            bindService.startCount();
		            //Log.i("twelfthActivity", "MAX_PROGRESS:"+bindService.getProgress()); 
		        }  
		    };  
  

}
