package hztg.king.test02;

import java.util.List;

import util.SensorUtil;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class sixteenActivity extends Activity {
	private final String LOG_TAG =getClass().getName();
	private SensorManager mSensorManager;
	private SensorUtil mSensor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sixteen);
		
		mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List <Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		for(Sensor sensor:sensors){
			Log.i(LOG_TAG, sensor.getName());
		}
		mSensor = new SensorUtil(this);
		mSensor.setOnShakeCallback(new SensorUtil.OnShakeCallback() {

			@Override
			public void onShake() {

				mSensor.stop();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mSensor.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		mSensor.stop();
	}
	
}
