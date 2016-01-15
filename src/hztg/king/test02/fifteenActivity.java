package hztg.king.test02;

import view.CustomView;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class fifteenActivity extends Activity {
	private CustomView mCustomView;// 我们的自定义View  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fifteen);
		//mCustomView =(CustomView) findViewById(R.id.fifteen_cv);
		
		//new Thread(mCustomView).start();
	}
	
}
