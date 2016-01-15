package hztg.king.test02;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class thirteenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirteen);

	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)) {
			finish();
			//overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
		}
		return super.onKeyDown(keyCode, event);
	}

}
