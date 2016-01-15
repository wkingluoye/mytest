/**
 * 
 */
package view;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author king
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PorterDuffView  extends View{
	private static final PorterDuff.Mode MODE = PorterDuff.Mode.ADD;
	private static final int RECT_SIZE_SMALL = 400;// 左右上方示例渐变正方形的尺寸大小 
	private static final int RECT_SIZE_BIG = 800;// 中间测试渐变正方形的尺寸大小
	private Paint mPaint ;
	
	private PorterDuff porterDuff;// PorterDuffView类的业务对象  
	private PorterDuffXfermode porterDuffXfermode;// 图形混合模式
	
	private int screenW, screenH;// 屏幕尺寸
	private int s_l, s_t;// 左上方正方形的原点坐标  
	private int d_l, d_t;// 右上方正方形的原点坐标
	private int rectX, rectY;// 中间正方形的原点坐标  
	
	
	public PorterDuffView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public PorterDuffView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG); 
		porterDuff  = new PorterDuff();
		porterDuffXfermode  = new PorterDuffXfermode(MODE);
		
		
	}
	
	private void calu(Context context){
		Activity   mActivity = (Activity)context;
		screenW = mActivity.getWindowManager().getDefaultDisplay().getWidth();
		screenH = mActivity.getWindowManager().getDefaultDisplay().getHeight();
		s_l = 0 ;
		s_t = 0 ;
		
		d_l = screenW - RECT_SIZE_SMALL;
		d_t = 0;
		
		rectX = screenW / 2;
		rectY = screenH /2 + RECT_SIZE_BIG/2;
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(R.color.black);
	}

}
