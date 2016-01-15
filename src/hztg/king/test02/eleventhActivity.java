package hztg.king.test02;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class eleventhActivity extends Activity {
	private static final String tag="App";
	private Context context;
	private View container;
	private Button btn,btn11;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//
        setContentView(R.layout.eleventh);
        context=this;
        container=findViewById(R.id.container);
        
        btn=(Button)findViewById(R.id.btn);
        //btn.setBackgroundResource(R.drawable.tabswitcher_short);
        btn.setOnTouchListener(touchLisener);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag,"btn clicked");
				
			}
		});
        btn11=(Button)findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				eleventhActivity.this.setContentView(R.layout.eleventh2);
			}
		});
    }
	 
	 
	 OnTouchListener touchLisener=new OnTouchListener() {
	    	int lastX, lastY;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					lastX = (int) event.getRawX();
	                lastY = (int) event.getRawY();
					break;
				case MotionEvent.ACTION_MOVE:
					int dx = (int) event.getRawX() - lastX;  
//					int dy = (int) event.getRawY() - lastY;  
	                int dy = 0;//y方向不需要

	                int left = v.getLeft() + dx;  
	                int top = v.getTop() + dy;  
	                int right = v.getRight() + dx;  
	                int bottom = v.getBottom() + dy;  

	                if (left < 0) {  
	                    left = 0;  
	                    right = left + v.getWidth();  
	                }  

	                if (right > container.getMeasuredWidth()) {  
	                    right = container.getMeasuredWidth();  
	                    left = right - v.getWidth();  
	                }  

	                if (top < 0) {  
	                    top = 0;  
	                    bottom = top + v.getHeight();  
	                }  

	                if (bottom > container.getMeasuredHeight()) {  
	                    bottom = container.getMeasuredHeight();  
	                    top = bottom - v.getHeight();  
	                }  

	                v.layout(left, top, right, bottom);  

	                lastX = (int) event.getRawX();
	                lastY = (int) event.getRawY();
					break;
				case MotionEvent.ACTION_UP:
					setBestPosition(v);
					break;

				default:
					break;
				}
				return false;
			}
		};
		//获得最佳停留位置
		private void setBestPosition(View v) {
			int width=v.getWidth();
	        int left = v.getLeft();
	        int selectedPosition = Math.round(1.0F*left/width);//四舍五入  
	        int toPosition = selectedPosition*width;  
	        v.layout(selectedPosition*width, v.getTop(),  
	                selectedPosition*width+width, v.getBottom());  
	        TranslateAnimation animation = new TranslateAnimation(left-toPosition,0,0,0);  
	        animation.setInterpolator(new LinearInterpolator());    
	        animation.setDuration(400);
	        animation.setFillAfter(true);
	        v.startAnimation(animation);
//	        v.invalidate();
	    }
}
