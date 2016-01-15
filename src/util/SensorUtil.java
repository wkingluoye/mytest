package util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Debug;
import android.os.Vibrator;
import android.util.Log;

/**
 * 一个检测手机摇晃的监听器
 */
public class SensorUtil implements SensorEventListener {
	// 速度阈值，当摇晃速度达到这值后产生作用
	private static final int SPEED_SHRESHOLD = 3000;
	// 两次检测的时间间隔
	private static final int UPTATE_INTERVAL_TIME = 100;
	// 两次摇动事件触发的间隔事件
	private static final int SHAKE_INTERVAL_TIME = 1000;
	// 传感器管理器
	private SensorManager mSensorManager;
	// 传感器
	private Sensor mSensor;
	// 震动器
	private Vibrator mVibrator;
	// 重力感应监听器
	private OnShakeCallback mOnShakeCallback;
	// 上下文
	private Context mContext;
	// 手机上一个位置时重力感应坐标
	private float lastX, lastY, lastZ;
	// 上次检测时间
	private long lastUpdateTime, listenerTime;
	// 忽略重力感应
	private boolean mIgnoreSensor, mOneTime = true;// 设置连续摇动两次是否只触发一次

	// 构造器
	public SensorUtil(Context context) {
		mContext = context;
		mOneTime = true;
	}

	public void reset() {
		mOneTime = true;
	}

	// 开始
	public void start() {
		// 获得传感器管理器
		mSensorManager = (SensorManager) mContext
				.getSystemService(Context.SENSOR_SERVICE);
		mVibrator = (Vibrator) mContext
				.getSystemService(Context.VIBRATOR_SERVICE);
		if (mSensorManager != null) {
			// 获得重力传感器
			mSensor = mSensorManager
					.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		}
		// 注册
		if (mSensor != null) {
			mSensorManager.registerListener(this, mSensor,
					SensorManager.SENSOR_DELAY_GAME);
		}
		listenerTime = System.currentTimeMillis();
		lastUpdateTime = System.currentTimeMillis();
	}

	// 停止检测
	public void stop() {
		if (mSensorManager == null) {
			return;
		}
		mSensorManager.unregisterListener(this);
	}

	// 设置重力感应监听器
	public void setOnShakeCallback(OnShakeCallback callback) {
		mOnShakeCallback = callback;
	}

	public void setIgnoreSensor(boolean isIgnore) {
		mIgnoreSensor = isIgnore;
	}

	// 重力感应器感应获得变化数据
	@Override
	public void onSensorChanged(SensorEvent event) {
		// 现在检测时间
		long currentUpdateTime = System.currentTimeMillis();

		// 两次检测的时间间隔
		long timeInterval = currentUpdateTime - lastUpdateTime;
		// 判断是否达到了检测时间间隔
		if (timeInterval < UPTATE_INTERVAL_TIME) {
			return;
		}
		lastUpdateTime = currentUpdateTime;

		// 获得x,y,z坐标
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];

		// 获得x,y,z的变化值
		float deltaX = x - lastX;
		float deltaY = y - lastY;
		float deltaZ = z - lastZ;

		// 将现在的坐标变成last坐标
		lastX = x;
		lastY = y;
		lastZ = z;
		
		double speed = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ
				* deltaZ)
				/ timeInterval * 10000;
		
		Log.i("King SensorTest", x+"|"+y+"|"+z+"|"+timeInterval+"|"+speed);
		// 达到速度阀值，发出提示
		if (speed >= SPEED_SHRESHOLD && !mIgnoreSensor && mOneTime) {
			long tmp = System.currentTimeMillis();
			if ((tmp - listenerTime) < SHAKE_INTERVAL_TIME) {
				return;
			}
			listenerTime = tmp;
			mOnShakeCallback.onShake();
			mVibrator.vibrate(500);// 震动0.5秒
			mOneTime = false;

		}
	}

	/**
	 * 
	 * 
	 * @param is
	 */
	public void setIsOneTime(boolean is) {
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public interface OnShakeCallback {
		public void onShake();
	}
}
