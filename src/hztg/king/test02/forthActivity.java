package hztg.king.test02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class forthActivity extends Activity{
	
	private int i=0;
	private Button myButton04_3=null;
	private ProgressBar myBar04_1=null;
	private ProgressBar myBar04_2=null;
	private Button myButton04_4=null;
	private Button myButton04_5=null;
	private Button myButton04_6=null;
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.forth);
		super.onCreate(savedInstanceState);
		
		myBar04_1 = (ProgressBar) findViewById(R.id.pBar1);
		myBar04_2 = (ProgressBar) findViewById(R.id.pBar2);
		myButton04_3 =(Button) findViewById(R.id.btn04_3);
		
		
		myButton04_3.setText("������");
		
		
		myButton04_3.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(i+"/"+myBar04_1.getMax());
				if(i==0){
					myBar04_1.setProgress(0);
					myBar04_1.setSecondaryProgress(0);
					myBar04_2.setProgress(0);
					myBar04_1.setVisibility(View.VISIBLE);
					myBar04_2.setVisibility(View.VISIBLE);
				}
				else if (i<myBar04_1.getMax()){
					myBar04_1.setProgress(i);
					myBar04_1.setSecondaryProgress(i+10);
					myBar04_2.setProgress(i);
					
				}
				else {
					myBar04_1.setVisibility(View.GONE);
					myBar04_2.setVisibility(View.GONE);					
				}
				
				i=i+10;
				if (i>myBar04_1.getMax()) i=0;
			}
			
		});
		
		myButton04_4 =(Button) findViewById(R.id.btn04_4);
		myButton04_4.setText(R.string.btn04_4);
		myButton04_4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println(R.string.btn04_4);
				//handler.post(updateThread);
			}
		});
		myButton04_5 =(Button) findViewById(R.id.btn04_5);
		myButton04_5.setText(R.string.btn04_5);
		myButton04_5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println(R.string.btn04_5);
				//handler.removeCallbacks(updateThread);
			}
		});
		myButton04_6 =(Button) findViewById(R.id.btn04_6);
		myButton04_6.setText(R.string.btn04_6);
		myButton04_6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myBar04_1.setVisibility(View.VISIBLE);
				barhandler.post(barUpdateThread);
			}
		});
	}
	
	/*Handler handler = new Handler();
	Runnable updateThread = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("updateThread");
			handler.postDelayed(updateThread, 5000);
		}
	};*/
	
	Handler barhandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			myBar04_1.setProgress(msg.arg1);
			barhandler.post(barUpdateThread);
			super.handleMessage(msg);
		}
	};
		
	Runnable barUpdateThread = new Runnable() {
		int i = 0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			i = i+10;
			System.out.println("Begin Thread:["+i+"]");
			Message msg = barhandler.obtainMessage();
			msg.arg1 = i;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			barhandler.sendMessage(msg);
			if(i==100){
				//barhandler.removeCallbacks(barUpdateThread);	
				barhandler.removeMessages(msg.what);			//��Ϣ����	 
				System.out.println("End Thread:["+i+"]");
			}
		}
	};
}
