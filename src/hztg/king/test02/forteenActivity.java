package hztg.king.test02;


import view.CircularImage;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class forteenActivity  extends Activity{

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forteen);  
		/*Animation anim = AnimationUtils.loadAnimation(this, R.anim.round);  
		ImageView radarImg = (ImageView) findViewById(R.id.radarImg);
		radarImg.setAlpha(180);
		radarImg.startAnimation(anim);*/ 
		CircularImage showImg = (CircularImage) findViewById(R.id.showImg);
		showImg.setImageResource(R.drawable.testheader);
	}
	
}
