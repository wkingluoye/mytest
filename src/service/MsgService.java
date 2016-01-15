package service;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;

public class MsgService extends Service {
		public static int MAX_PROGRESS = 100;
		//private static Thread 	    m_ThreadNetState = null;
		private static Timer  		m_NetStateTimer = null; //心跳包Timer
		private static TimerTask 	m_NetStateTimerTask = null;	//心跳包TimerTask
		
		
		public int getProgress() {
			return MAX_PROGRESS;
		}

		public void startCount() {
			m_NetStateTimerTask = new TimerTask() {
				public void run() {
					//m_handler.sendMessage(m_handler.obtainMessage(GlobalDef.WM_OFFLINE_NETSTATE, 0, 0, sendContent));
					//m_Socket.AddWriteBuffer(buffer);
					Log.i("MsgService", "MsgService-->"+MAX_PROGRESS);
					MAX_PROGRESS = MAX_PROGRESS + 1;
				}
			};
			m_NetStateTimer = new Timer(true);
			m_NetStateTimer.schedule(m_NetStateTimerTask, 1000, 2000);
		}
		public void stopCount() {
			m_NetStateTimer.cancel();
		}

		@Override
		public void onCreate() {
			Log.i("MsgService", "MsgService-->onCreate");
			super.onCreate();
			
		}



		@Override
		public void onDestroy() {
			Log.i("MsgService", "MsgService-->onDestroy");
			super.onDestroy();
			
		}



		@Override
		public void onStart(Intent intent, int startId) {
			Log.i("MsgService", "MsgService-->onStart");
			super.onStart(intent, startId);
		}



		/**
		 * 返回一个Binder对象
		 */
		@Override
		public IBinder onBind(Intent intent) {
			Log.i("MsgService", "MsgService-->onBind");
			return new MsgBinder();
		}
		
		public class MsgBinder extends Binder{
			/**
			 * 获取当前Service的实例
			 * @return
			 */
			public MsgService getService(){
				return MsgService.this;
			}
		}


}
