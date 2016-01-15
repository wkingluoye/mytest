package view;

import hztg.king.test02.R;
import hztg.king.test02.ninthActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View  implements Runnable{
	private Paint mPaint ;
	private Context mContext;
	
	private Bitmap bitmap;// 位图  
	private int x,y;// 位图绘制时左上角的起点坐标  

	private int radiu; 	//半径
	private boolean isClick;// 用来标识控件是否被点击过  
	
	public CustomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		radiu = 200 ;
		// 初始化画笔  
		initPaint();
		
		// 初始化资源 
		initRes(context);
		
		setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(isClick){
					mPaint.setColorFilter(null);
					isClick = false;
				}else {
					mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FF0000)); 
					isClick = true;
				}
				invalidate();
			}
		});
	}
	
	private void initPaint(){
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//mPaint .setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setColor(Color.BLUE);
		mPaint.setStrokeWidth(5);
		
		ColorMatrix  colorMatrix = new ColorMatrix(new float[]{
				1F, 0, 0, 0, 0,
				0, 0.3F, 0, 0, 0,
				0, 0, 0.3F, 0, 0,
				0, 0, 0, 1, 0
		});
		//mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		//mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
	}
	
	private void initRes(Context context){
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xing);
		x = bitmap.getWidth();
		y = bitmap.getHeight();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//canvas.drawCircle((canvas.getWidth())/2, (canvas.getHeight())/2, radiu, mPaint);  
		canvas.drawBitmap(bitmap, (canvas.getWidth()-x)/2, (canvas.getHeight()-y)/2, mPaint);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				if(radiu <= 200){
					radiu ++;
					postInvalidate();
				}else {
					radiu = 0;
				}
				
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
