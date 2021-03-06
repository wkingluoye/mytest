package util;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service implements ICounterService {
	private final static String LOG_TAG = "shy.luo.broadcast.CounterService";

	public final static String BROADCAST_COUNTER_ACTION = "broadcast.COUNTER_ACTION";
	public final static String COUNTER_VALUE = "broadcast.counter.value";

	private boolean stop = false;

	private final IBinder binder = new CounterBinder();

	public class CounterBinder extends Binder {
		public CounterService getService() {
			return CounterService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		Log.i(LOG_TAG, "Counter Service Created.");
	}

	@Override
	public void onDestroy() {
		Log.i(LOG_TAG, "Counter Service Destroyed.");
	}

	public void startCounter(int initVal) {
		AsyncTask<Integer, Integer, Integer> task = new AsyncTask<Integer, Integer, Integer>() {
			@Override
			protected Integer doInBackground(Integer... vals) {
				Integer initCounter = vals[0];

				stop = false;
				while (!stop) {
					publishProgress(initCounter);

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					initCounter++;
				}

				return initCounter;
			}

			@Override
			protected void onProgressUpdate(Integer... values) {
				super.onProgressUpdate(values);

				int counter = values[0];

				Intent intent = new Intent(BROADCAST_COUNTER_ACTION);
				intent.putExtra(COUNTER_VALUE, counter);

				sendBroadcast(intent);
			}

			@Override
			protected void onPostExecute(Integer val) {
				int counter = val;

				Intent intent = new Intent(BROADCAST_COUNTER_ACTION);
				intent.putExtra(COUNTER_VALUE, counter);

				sendBroadcast(intent);
			}

		};

		task.execute(0);
	}

	public void stopCounter() {
		stop = true;
	}
}